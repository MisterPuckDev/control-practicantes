package pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiErrorResponse;
import pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.service.BucketService;

import java.io.IOException;

/**
 * Applies API rate limiting before authentication.
 *
 * <p>Every incoming request consumes one token from its assigned bucket.
 * Authenticated users are limited by username, while anonymous users are
 * limited by client IP address.
 *
 * <p>When the limit is exceeded, the filter returns HTTP 429 using the
 * application's standard error contract.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Component
public class RateLimitFilter extends OncePerRequestFilter {

    /**
     * Bucket resolution service.
     */
    private final BucketService bucketService;

    /**
     * JSON serializer.
     */
    private final ObjectMapper objectMapper;

    /**
     * Creates the rate limiting filter.
     *
     * @param bucketService bucket resolution service.
     * @param objectMapper  JSON serializer.
     */
    public RateLimitFilter(
        BucketService bucketService,
        ObjectMapper objectMapper) {

        this.bucketService = bucketService;
        this.objectMapper = objectMapper;
    }

    /**
     * Applies rate limiting before continuing the filter chain.
     *
     * @param request     current HTTP request.
     * @param response    current HTTP response.
     * @param filterChain remaining filter chain.
     * @throws ServletException if servlet processing fails.
     * @throws IOException      if response writing fails.
     */
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

        Bucket bucket = bucketService.resolveBucket(request);

        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);

        response.setHeader(
            "X-RateLimit-Remaining",
            String.valueOf(probe.getRemainingTokens()));

        if (probe.isConsumed()) {

            filterChain.doFilter(request, response);
            return;

        }

        long retryAfter =
            Math.max(1, probe.getNanosToWaitForRefill() / 1_000_000_000);

        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        response.setHeader("Retry-After", String.valueOf(retryAfter));

        objectMapper.writeValue(
            response.getWriter(),
            ApiErrorResponse.of(
                HttpStatus.TOO_MANY_REQUESTS.value(),
                "RATE_LIMIT_EXCEEDED",
                "Too many requests. Please try again later."));
    }

}
