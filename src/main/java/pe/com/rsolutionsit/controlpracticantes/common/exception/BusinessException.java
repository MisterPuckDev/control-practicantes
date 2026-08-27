package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Base class for business exceptions.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public abstract class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    protected BusinessException(ErrorCode errorCode) {

        super(errorCode.message());

        this.errorCode = errorCode;

    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getCode() {
        return errorCode.code();
    }

    public HttpStatus getStatus() {
        return errorCode.status();
    }
}
