package pe.com.rsolutionsit.controlpracticantes.common.exception.catalog;

import org.springframework.http.HttpStatus;
import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCode;

/**
 * Common application errors shared across every module.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public enum CommonErrors implements ErrorCode {

    VALIDATION_ERROR(

        "COMMON_001",

        "Validation error.",

        HttpStatus.BAD_REQUEST),

    INTERNAL_ERROR(

        "COMMON_999",

        "Unexpected internal error.",

        HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;

    private final String message;

    private final HttpStatus status;

    CommonErrors(
        String code,
        String message,
        HttpStatus status) {

        this.code = code;
        this.message = message;
        this.status = status;

    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public HttpStatus status() {
        return status;
    }

}
