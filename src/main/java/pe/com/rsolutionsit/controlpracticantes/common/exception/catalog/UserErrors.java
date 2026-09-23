package pe.com.rsolutionsit.controlpracticantes.common.exception.catalog;

import org.springframework.http.HttpStatus;
import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCode;

/**
 * User-related error catalog.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public enum UserErrors implements ErrorCode {

    USER_NOT_FOUND(
        "USER_001",
        "User not found.",
        HttpStatus.NOT_FOUND),

    USERNAME_ALREADY_EXISTS(
        "USER_002",
        "Username already exists.",
        HttpStatus.CONFLICT),

    EMAIL_ALREADY_EXISTS(
        "USER_003",
        "Email already exists.",
        HttpStatus.CONFLICT);

    private final String code;
    private final String message;
    private final HttpStatus status;

    UserErrors(
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
