package pe.com.rsolutionsit.controlpracticantes.common.constants;

/**
 * Centralizes trace-related constants used across the application.
 *
 * <p>Keeping these values in a single place avoids duplicated literals and
 * guarantees consistency between filters, exception handlers and logging.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public final class TraceConstants {

    /**
     * HTTP header used to propagate the trace identifier.
     */
    public static final String TRACE_HEADER = "X-Trace-Id";

    /**
     * MDC key used by SLF4J.
     */
    public static final String TRACE_ID = "traceId";

    /**
     * Prevents instantiation of the utility class.
     */
    private TraceConstants() {
        throw new IllegalStateException("Utility class");
    }
}
