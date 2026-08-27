package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Indicates that a business validation failed.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public class ValidationException extends BusinessException {

    public ValidationException(String message) {
        super(message);
    }

    @Override
    public String getCode() {
        return "VALIDATION_ERROR";
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
