package pe.com.rsolutionsit.controlpracticantes.common.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.com.rsolutionsit.controlpracticantes.common.constants.TraceConstants;

import java.io.IOException;
import java.security.SecureRandom;

/**
 * Generates and propagates a trace identifier for every HTTP request.
 *
 * <p>If the client already provides an {@code X-Trace-Id} header, the same
 * identifier is reused. Otherwise, a cryptographically secure 128-bit
 * hexadecimal identifier is generated.
 *
 * <p>The trace identifier is:
 *
 * <ul>
 *     <li>Stored in SLF4J MDC.</li>
 *     <li>Returned in the HTTP response.</li>
 *     <li>Available for exception handlers and audit logging.</li>
 * </ul>
 *
 * <p>The generated format is compatible with modern observability tools such
 * as OpenTelemetry, Jaeger and Zipkin.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Component
public class RequestTraceFilter extends OncePerRequestFilter {

    /**
     * Cryptographically secure random number generator used to create
     * trace identifiers.
     */
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    /**
     * Applies trace propagation to every incoming request.
     *
     * @param request     current HTTP request.
     * @param response    current HTTP response.
     * @param filterChain remaining filter chain.
     * @throws ServletException if servlet processing fails.
     * @throws IOException      if request processing fails.
     */
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

        String traceId = resolveTraceId(request);

        MDC.put(TraceConstants.TRACE_ID, traceId);

        response.setHeader(TraceConstants.TRACE_HEADER, traceId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(TraceConstants.TRACE_ID);
        }
    }

    /**
     * Resolves the trace identifier for the current request.
     *
     * <p>If the client already provides a valid trace identifier through the
     * {@code X-Trace-Id} header, that value is reused. Otherwise, a new
     * cryptographically secure identifier is generated.
     *
     * @param request current HTTP request.
     * @return trace identifier.
     */
    private String resolveTraceId(HttpServletRequest request) {

        String traceId = request.getHeader(TraceConstants.TRACE_HEADER);

        if (traceId != null && isValidTraceId(traceId)) {
            return traceId.toLowerCase();
        }

        return generateTraceId();
    }

    /**
     * Generates a new 128-bit hexadecimal trace identifier.
     *
     * @return 32-character hexadecimal trace identifier.
     */
    private String generateTraceId() {

        byte[] bytes = new byte[16];

        SECURE_RANDOM.nextBytes(bytes);

        StringBuilder builder = new StringBuilder(32);

        for (byte value : bytes) {
            builder.append(String.format("%02x", value));
        }

        return builder.toString();
    }

    /**
     * Validates that the supplied trace identifier matches the expected
     * hexadecimal format.
     *
     * @param traceId trace identifier received from the client.
     * @return {@code true} if the identifier is valid; otherwise {@code false}.
     */
    private boolean isValidTraceId(String traceId) {

        return traceId.matches("^[a-fA-F0-9]{32}$");
    }
}
