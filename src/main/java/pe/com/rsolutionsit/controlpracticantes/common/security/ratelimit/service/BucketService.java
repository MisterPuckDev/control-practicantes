package pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.config.RateLimitProperties;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Manages Bucket4j buckets used by API rate limiting.
 *
 * <p>Authenticated users are limited by username, while anonymous users are
 * limited by client IP address.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Service
public class BucketService {

    /**
     * In-memory bucket cache.
     */
    private final Map<String, Bucket> buckets =
        new ConcurrentHashMap<>();

    /**
     * Rate limit configuration.
     */
    private final RateLimitProperties properties;

    /**
     * Creates the bucket service.
     *
     * @param properties rate limit configuration.
     */
    public BucketService(RateLimitProperties properties) {

        this.properties = properties;
    }

    /**
     * Returns the bucket assigned to the current request.
     *
     * @param request current HTTP request.
     * @return request bucket.
     */
    public Bucket resolveBucket(HttpServletRequest request) {

        String key = resolveKey(request);

        return buckets.computeIfAbsent(key, ignored -> createBucket());
    }

    /**
     * Creates a new bucket.
     *
     * @return configured bucket.
     */
    private Bucket createBucket() {

        Bandwidth bandwidth = Bandwidth.classic(

            properties.getCapacity(),

            Refill.greedy(

                properties.getRefillTokens(),

                properties.getRefillDuration()));

        return Bucket.builder()

            .addLimit(bandwidth)

            .build();

    }

    /**
     * Resolves the bucket key.
     *
     * @param request current HTTP request.
     * @return unique bucket identifier.
     */
    private String resolveKey(HttpServletRequest request) {

        Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null
            && authentication.isAuthenticated()
            && !"anonymousUser".equals(authentication.getName())) {

            return "USER:" + authentication.getName();

        }

        return "IP:" + extractClientIp(request);
    }

    /**
     * Extracts the client IP.
     *
     * @param request current HTTP request.
     * @return client IP address.
     */
    private String extractClientIp(HttpServletRequest request) {

        String forwarded = request.getHeader("X-Forwarded-For");

        if (forwarded != null && !forwarded.isBlank()) {

            return forwarded.split(",")[0].trim();

        }

        return request.getRemoteAddr();
    }

}
