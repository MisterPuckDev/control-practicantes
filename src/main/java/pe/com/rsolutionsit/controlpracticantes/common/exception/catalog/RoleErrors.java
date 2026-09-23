package pe.com.rsolutionsit.controlpracticantes.common.exception.catalog;

import org.springframework.http.HttpStatus;
import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCode;

/**
 * Role-related error catalog.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public enum RoleErrors implements ErrorCode {

    ROLE_NOT_FOUND(
        "ROLE_001",
        "Role not found.",
        HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;

    RoleErrors(
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
