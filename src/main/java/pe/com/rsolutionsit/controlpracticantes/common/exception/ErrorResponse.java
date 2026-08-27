package pe.com.rsolutionsit.controlpracticantes.common.exception;

import java.time.LocalDateTime;

/**
 * Standard API error response.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record ErrorResponse(

    String code,

    String message,

    int status,

    String path,

    String traceId,

    LocalDateTime timestamp

) {
}
