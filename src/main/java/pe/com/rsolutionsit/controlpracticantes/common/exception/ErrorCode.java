package pe.com.rsolutionsit.controlpracticantes.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Contract implemented by every application error code.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public interface ErrorCode {

    /**
     * Stable application error code.
     */
    String code();

    /**
     * Default error message.
     */
    String message();

    /**
     * Associated HTTP status.
     */
    HttpStatus status();

}
