package pe.com.rsolutionsit.controlpracticantes.common.exception.model;

import org.springframework.http.HttpStatus;
import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCode;

/**
 * Runtime implementation of {@link ErrorCode}.
 *
 * <p>This implementation allows overriding only the message while preserving
 * the official application code and HTTP status.
 *
 * @param code    application error code.
 * @param message custom message.
 * @param status  HTTP status.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record DynamicErrorCode(

    String code,

    String message,

    HttpStatus status

) implements ErrorCode {
}
