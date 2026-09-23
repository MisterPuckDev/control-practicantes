package pe.com.rsolutionsit.controlpracticantes.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pe.com.rsolutionsit.controlpracticantes.common.exception.catalog.AuthErrors;
import pe.com.rsolutionsit.controlpracticantes.common.exception.catalog.CommonErrors;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiErrorResponse;

/**
 * Centralized REST exception handler.
 *
 * <p>Every exception is converted into the application's standardized error
 * contract.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusiness(
        BusinessException exception) {

        LOGGER.warn("{} - {}", exception.getCode(), exception.getMessage());

        return ResponseEntity

            .status(exception.getStatus())

            .body(ApiErrorResponse.of(

                exception.getStatus().value(),

                exception.getCode(),

                exception.getMessage()));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidation(
        MethodArgumentNotValidException exception) {

        String message = exception.getBindingResult()

            .getFieldErrors()

            .stream()

            .findFirst()

            .map(error -> error.getField() + ": " + error.getDefaultMessage())

            .orElse(CommonErrors.VALIDATION_ERROR.message());

        return ResponseEntity.badRequest()

            .body(ApiErrorResponse.of(

                400,

                CommonErrors.VALIDATION_ERROR.code(),

                message));

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolation(
        ConstraintViolationException exception) {

        return ResponseEntity.badRequest()

            .body(ApiErrorResponse.of(

                400,

                CommonErrors.VALIDATION_ERROR.code(),

                exception.getMessage()));

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiErrorResponse> handleTypeMismatch(
        MethodArgumentTypeMismatchException exception) {

        return ResponseEntity.badRequest()

            .body(ApiErrorResponse.of(

                400,

                CommonErrors.VALIDATION_ERROR.code(),

                "Invalid parameter: " + exception.getName()));

    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiErrorResponse> handleAuthentication(
        AuthenticationException exception) {

        return ResponseEntity.status(401)

            .body(ApiErrorResponse.of(

                401,

                AuthErrors.UNAUTHORIZED.code(),

                AuthErrors.UNAUTHORIZED.message()));

    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiErrorResponse> handleAccessDenied(
        AccessDeniedException exception) {

        return ResponseEntity.status(403)

            .body(ApiErrorResponse.of(

                403,

                AuthErrors.FORBIDDEN.code(),

                AuthErrors.FORBIDDEN.message()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnexpected(
        Exception exception,
        HttpServletRequest request) {

        LOGGER.error(

            "Unexpected error. traceId={}",

            request.getHeader("X-Trace-Id"),

            exception);

        return ResponseEntity.internalServerError()

            .body(ApiErrorResponse.of(

                500,

                CommonErrors.INTERNAL_ERROR.code(),

                CommonErrors.INTERNAL_ERROR.message()));

    }

}
