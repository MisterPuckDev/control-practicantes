package pe.com.rsolutionsit.controlpracticantes.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Global API exception handler.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusiness(
        BusinessException ex,
        HttpServletRequest request) {

        LOGGER.warn("{} - {}", ex.getCode(), ex.getMessage());

        return ResponseEntity
            .status(ex.getStatus())
            .body(buildError(
                ex.getCode(),
                ex.getMessage(),
                ex.getStatus().value(),
                request.getRequestURI()));

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
            .orElse(ErrorCatalog.VALIDATION_ERROR.message());

        return ResponseEntity.badRequest().body(buildError(
            ErrorCatalog.VALIDATION_ERROR.code(),
            message,
            400,
            request.getRequestURI()));

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(
        Exception ex,
        HttpServletRequest request) {

        String traceId = UUID.randomUUID().toString();

        LOGGER.error("Unexpected error [{}]", traceId, ex);

        return ResponseEntity.internalServerError().body(buildError(
            ErrorCatalog.INTERNAL_ERROR.code(),
            ErrorCatalog.INTERNAL_ERROR.message(),
            500,
            request.getRequestURI(),
            traceId));

    }

    private ErrorResponse buildError(
        String code,
        String message,
        int status,
        String path) {

        return buildError(code, message, status, path, UUID.randomUUID().toString());

    }

    private ErrorResponse buildError(
        String code,
        String message,
        int status,
        String path,
        String traceId) {

        return new ErrorResponse(
            code,
            message,
            status,
            path,
            traceId,
            LocalDateTime.now());

    }
}
