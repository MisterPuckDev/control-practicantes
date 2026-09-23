package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Contract implemented by every application error code.
 *
 * <p>Error codes are stable identifiers that should never change once they
 * become part of the public API.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
public interface ErrorCode {

    /**
     * Returns the stable application error code.
     *
     * @return application error code.
     */
    String code();

    /**
     * Returns the default error message.
     *
     * @return default message.
     */
    String message();

    /**
     * Returns the associated HTTP status.
     *
     * @return HTTP status.
     */
    HttpStatus status();
}
