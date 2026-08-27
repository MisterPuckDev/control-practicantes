package pe.com.rsolutionsit.controlpracticantes.modules.auth.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCatalog;

/**
 * Expired JWT token.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public class TokenExpiredException extends AuthException {

    public TokenExpiredException() {
        super(ErrorCatalog.AUTH_TOKEN_EXPIRED);
    }
}
