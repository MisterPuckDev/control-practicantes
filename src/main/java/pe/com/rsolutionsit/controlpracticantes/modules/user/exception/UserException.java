package pe.com.rsolutionsit.controlpracticantes.modules.user.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.BusinessException;
import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCode;

/**
 * Base user exception.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public abstract class UserException extends BusinessException {

    protected UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
