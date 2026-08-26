package pe.com.rsolutionsit.controlpracticantes.common.exception;

import java.time.LocalDateTime;

/**
 * Representa una respuesta estándar ante errores.
 */
public record ErrorResponse(

        String code,

        String message,

        int status,

        String path,

        LocalDateTime timestamp

) {}