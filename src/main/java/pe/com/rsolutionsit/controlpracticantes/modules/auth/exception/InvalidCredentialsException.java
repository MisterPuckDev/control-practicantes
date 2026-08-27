package pe.com.rsolutionsit.controlpracticantes.modules.auth.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCatalog;

/**
 * Thrown when credentials are invalid.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public class InvalidCredentialsException extends AuthException {

    public InvalidCredentialsException() {
        super(ErrorCatalog.AUTH_INVALID_CREDENTIALS);
    }
}
