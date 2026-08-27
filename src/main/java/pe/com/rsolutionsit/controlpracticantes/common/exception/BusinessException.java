package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Base class for business exceptions.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public abstract class BusinessException extends RuntimeException {

    protected BusinessException(String message) {
        super(message);
    }

    /**
     * Error code.
     */
    public abstract String getCode();

    /**
     * HTTP status associated with the exception.
     */
    public abstract HttpStatus getStatus();
}
