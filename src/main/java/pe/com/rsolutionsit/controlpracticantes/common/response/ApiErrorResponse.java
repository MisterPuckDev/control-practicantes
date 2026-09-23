package pe.com.rsolutionsit.controlpracticantes.common.response;

import org.slf4j.MDC;
import pe.com.rsolutionsit.controlpracticantes.common.constants.TraceConstants;

import java.time.LocalDateTime;

/**
 * Standard API error response.
 *
 * <p>This contract is returned by every error handler in the application,
 * including Spring Security, GlobalExceptionHandler and infrastructure
 * filters.
 *
 * @param timestamp response creation time.
 * @param status    HTTP status.
 * @param code      application error code.
 * @param message   user-friendly message.
 * @param traceId   request correlation identifier.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record ApiErrorResponse(

    LocalDateTime timestamp,

    int status,

    String code,

    String message,

    String traceId
) {

    /**
     * Creates a standardized error response using the current trace identifier.
     *
     * @param status  HTTP status.
     * @param code    application error code.
     * @param message user-friendly message.
     * @return standardized error response.
     */
    public static ApiErrorResponse of(
        int status,
        String code,
        String message) {

        return new ApiErrorResponse(
            LocalDateTime.now(),
            status,
            code,
            message,
            MDC.get(TraceConstants.TRACE_ID));
    }
}
