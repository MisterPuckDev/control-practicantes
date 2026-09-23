package pe.com.rsolutionsit.controlpracticantes.modules.auth.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.catalog.AuthErrors;

/**
 * Invalid JWT token.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public class InvalidTokenException extends AuthException {

    public InvalidTokenException() {
        super(AuthErrors.INVALID_TOKEN);
    }
}
