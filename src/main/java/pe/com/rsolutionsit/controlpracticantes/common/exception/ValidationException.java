package pe.com.rsolutionsit.controlpracticantes.common.exception;

/**
 * Generic business validation exception.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public class ValidationException extends BusinessException {

    public ValidationException() {
        super(ErrorCatalog.VALIDATION_ERROR);
    }

    public ValidationException(String message) {
        super(new ErrorCode() {

            @Override
            public String code() {
                return ErrorCatalog.VALIDATION_ERROR.code();
            }

            @Override
            public String message() {
                return message;
            }

            @Override
            public org.springframework.http.HttpStatus status() {
                return ErrorCatalog.VALIDATION_ERROR.status();
            }
        });
    }
}
