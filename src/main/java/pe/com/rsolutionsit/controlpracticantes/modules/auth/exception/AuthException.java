package pe.com.rsolutionsit.controlpracticantes.modules.auth.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.BusinessException;
import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCode;

/**
 * Base authentication exception.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public abstract class AuthException extends BusinessException {

    protected AuthException(ErrorCode errorCode) {
        super(errorCode);
    }
}
