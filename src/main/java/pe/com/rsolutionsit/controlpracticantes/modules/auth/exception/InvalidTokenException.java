package pe.com.rsolutionsit.controlpracticantes.modules.auth.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCatalog;

/**
 * Invalid JWT token.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public class InvalidTokenException extends AuthException {

    public InvalidTokenException() {
        super(ErrorCatalog.AUTH_INVALID_TOKEN);
    }
}
