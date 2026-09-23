package pe.com.rsolutionsit.controlpracticantes.modules.auth.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.catalog.AuthErrors;

/**
 * Thrown when credentials are invalid.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public class InvalidCredentialsException extends AuthException {

    public InvalidCredentialsException() {
        super(AuthErrors.INVALID_CREDENTIALS);
    }
}
