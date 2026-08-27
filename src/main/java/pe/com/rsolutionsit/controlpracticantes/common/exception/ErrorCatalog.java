package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Official application error catalog.
 * <p>
 * These codes are stable and should never change once published.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public enum ErrorCatalog implements ErrorCode {

    AUTH_INVALID_CREDENTIALS(
        "AUTH_001",
        "Invalid credentials.",
        HttpStatus.UNAUTHORIZED),

    AUTH_INVALID_TOKEN(
        "AUTH_002",
        "Invalid token.",
        HttpStatus.UNAUTHORIZED),

    AUTH_TOKEN_EXPIRED(
        "AUTH_003",
        "Token expired.",
        HttpStatus.UNAUTHORIZED),

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
        HttpStatus.CONFLICT),

    ROLE_NOT_FOUND(
        "ROLE_001",
        "Role not found.",
        HttpStatus.NOT_FOUND),

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

    ErrorCatalog(
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
