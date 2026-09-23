package pe.com.rsolutionsit.controlpracticantes.modules.auth.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.catalog.AuthErrors;

/**
 * Expired JWT token.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public class TokenExpiredException extends AuthException {

    public TokenExpiredException() {
        super(AuthErrors.TOKEN_EXPIRED);
    }
}
