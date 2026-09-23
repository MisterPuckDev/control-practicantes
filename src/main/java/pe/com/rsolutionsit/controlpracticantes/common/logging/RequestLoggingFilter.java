package pe.com.rsolutionsit.controlpracticantes.common.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.com.rsolutionsit.controlpracticantes.common.constants.TraceConstants;

import java.io.IOException;

/**
 * Logs every HTTP request after completion.
 *
 * <p>The generated trace identifier allows correlation between logs,
 * exceptions and API responses.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    /**
     * Logger.
     */
    private static final Logger LOGGER =
        LoggerFactory.getLogger(RequestLoggingFilter.class);

    /**
     * Logs request information after processing.
     *
     * @param request     current request.
     * @param response    current response.
     * @param filterChain remaining filter chain.
     * @throws ServletException servlet failure.
     * @throws IOException      I/O failure.
     */
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

        long start = System.currentTimeMillis();

        try {

            filterChain.doFilter(request, response);

        } finally {

            long duration = System.currentTimeMillis() - start;

            LOGGER.info(

                "traceId={} method={} path={} status={} durationMs={}",

                MDC.get(TraceConstants.TRACE_ID),

                request.getMethod(),

                request.getRequestURI(),

                response.getStatus(),

                duration);

        }
    }
}
