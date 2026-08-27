package pe.com.rsolutionsit.controlpracticantes.common.exception;

/**
 * Generic exception thrown when a requested resource does not exist.
 * <p>
 * Whenever possible, prefer module-specific exceptions such as
 * {@code UserNotFoundException}.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException() {
        super(ErrorCatalog.USER_NOT_FOUND);
    }
}
