package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Indica que un recurso solicitado no existe.
 */
public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getCode() {
        return "RESOURCE_NOT_FOUND";
    }

    @Override
    public int getStatus() {
        return HttpStatus.NOT_FOUND.value();
    }
}