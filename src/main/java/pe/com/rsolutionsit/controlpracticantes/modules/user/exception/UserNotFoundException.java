package pe.com.rsolutionsit.controlpracticantes.modules.user.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ErrorCatalog;

/**
 * User not found.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public class UserNotFoundException extends UserException {

    public UserNotFoundException() {
        super(ErrorCatalog.USER_NOT_FOUND);
    }
}
