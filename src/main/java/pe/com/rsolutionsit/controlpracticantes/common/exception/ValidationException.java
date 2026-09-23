package pe.com.rsolutionsit.controlpracticantes.common.exception;

import pe.com.rsolutionsit.controlpracticantes.common.exception.catalog.CommonErrors;
import pe.com.rsolutionsit.controlpracticantes.common.exception.model.DynamicErrorCode;

/**
 * Generic validation exception.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public class ValidationException extends BusinessException {

    /**
     * Creates a validation exception using the default message.
     */
    public ValidationException() {

        super(CommonErrors.VALIDATION_ERROR);
    }

    /**
     * Creates a validation exception using a custom message.
     *
     * @param message custom validation message.
     */
    public ValidationException(String message) {

        super(new DynamicErrorCode(

            CommonErrors.VALIDATION_ERROR.code(),

            message,

            CommonErrors.VALIDATION_ERROR.status()));

    }
}
