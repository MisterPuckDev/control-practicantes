package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Indica que una validación de negocio no fue superada.
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
    public int getStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}