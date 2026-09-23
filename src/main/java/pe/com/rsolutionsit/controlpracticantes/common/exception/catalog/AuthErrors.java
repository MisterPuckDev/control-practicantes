package pe.com.rsolutionsit.controlpracticantes.common.exception.catalog;

import org.springframework.http.HttpStatus;
import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCode;

/**
 * Authentication-related error catalog.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public enum AuthErrors implements ErrorCode {

    INVALID_CREDENTIALS(
        "AUTH_001",
        "Invalid credentials.",
        HttpStatus.UNAUTHORIZED),

    INVALID_TOKEN(
        "AUTH_002",
        "Invalid token.",
        HttpStatus.UNAUTHORIZED),

    TOKEN_EXPIRED(
        "AUTH_003",
        "Token expired.",
        HttpStatus.UNAUTHORIZED),

    UNAUTHORIZED(
        "AUTH_004",
        "Authentication is required.",
        HttpStatus.UNAUTHORIZED),

    FORBIDDEN(
        "AUTH_005",
        "Access denied.",
        HttpStatus.FORBIDDEN);

    private final String code;
    private final String message;
    private final HttpStatus status;

    AuthErrors(
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
