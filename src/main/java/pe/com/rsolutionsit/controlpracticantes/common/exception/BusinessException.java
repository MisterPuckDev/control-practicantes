package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Base class for every business exception.
 *
 * <p>All application-specific exceptions inherit from this class, allowing the
 * global exception handler to produce a consistent API response.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public abstract class BusinessException extends RuntimeException {

    /**
     * Error definition.
     */
    private final ErrorCode errorCode;

    /**
     * Creates a business exception.
     *
     * @param errorCode application error definition.
     */
    protected BusinessException(ErrorCode errorCode) {

        super(errorCode.message());

        this.errorCode = errorCode;
    }

    /**
     * Returns the error definition.
     *
     * @return error definition.
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * Returns the stable application error code.
     *
     * @return application error code.
     */
    public String getCode() {
        return errorCode.code();
    }

    /**
     * Returns the associated HTTP status.
     *
     * @return HTTP status.
     */
    public HttpStatus getStatus() {
        return errorCode.status();
    }
}
