package pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.model;

import java.time.Instant;

/**
 * Standard response returned when the API rate limit is exceeded.
 *
 * <p>The response follows the application's error contract and avoids exposing
 * internal implementation details.
 *
 * @param timestamp response generation time.
 * @param code      application error code.
 * @param message   user-friendly error message.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record RateLimitResponse(

    Instant timestamp,

    String code,

    String message
) {
}
