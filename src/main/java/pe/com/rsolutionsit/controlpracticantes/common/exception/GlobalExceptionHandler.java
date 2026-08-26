package pe.com.rsolutionsit.controlpracticantes.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Maneja globalmente las excepciones del sistema.
 *
 * Centraliza el formato de las respuestas de error.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException ex,
            HttpServletRequest request) {

        return ResponseEntity
                .status(ex.getStatus())
                .body(new ErrorResponse(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getStatus(),
                        request.getRequestURI(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedException(
            Exception ex,
            HttpServletRequest request) {

        return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse(
                        "INTERNAL_SERVER_ERROR",
                        "Ha ocurrido un error inesperado.",
                        500,
                        request.getRequestURI(),
                        LocalDateTime.now()
                ));
    }
}