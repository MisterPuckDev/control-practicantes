package pe.com.rsolutionsit.controlpracticantes.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Global exception handler.
 * <p>
 * Centralizes all API error responses.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
        BusinessException ex,
        HttpServletRequest request) {

        return ResponseEntity
            .status(ex.getStatus())
            .body(buildError(
                ex.getCode(),
                ex.getMessage(),
                ex.getStatus().value(),
                request.getRequestURI()
            ));

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
        MethodArgumentNotValidException ex,
        HttpServletRequest request) {

        String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .findFirst()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .orElse("Validation error.");

        return ResponseEntity
            .badRequest()
            .body(buildError(
                "VALIDATION_ERROR",
                message,
                400,
                request.getRequestURI()
            ));

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(
        Exception ex,
        HttpServletRequest request) {

        return ResponseEntity
            .internalServerError()
            .body(buildError(
                "INTERNAL_SERVER_ERROR",
                "An unexpected error occurred.",
                500,
                request.getRequestURI()
            ));

    }

    private ErrorResponse buildError(
        String code,
        String message,
        int status,
        String path) {

        return new ErrorResponse(
            code,
            message,
            status,
            path,
            UUID.randomUUID().toString(),
            LocalDateTime.now()
        );

    }
}
