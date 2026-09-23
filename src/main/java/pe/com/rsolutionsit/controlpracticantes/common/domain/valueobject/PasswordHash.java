package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

import java.util.Objects;

/**
 * Immutable BCrypt password hash.
 *
 * <p>This value object represents an already encoded password.
 *
 * @param value BCrypt hash.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record PasswordHash(String value) {

    /**
     * BCrypt hash pattern.
     */
    private static final String BCRYPT_PATTERN =
        "^\$2[aby]\$.{56}$";

    /**
     * Creates a validated password hash.
     *
     * @param value BCrypt hash.
     */
    public PasswordHash {

        Objects.requireNonNull(value);

        value = value.trim();

        if (!value.matches(BCRYPT_PATTERN)) {

            throw new ValidationException(
                "Invalid BCrypt password hash.");

        }
    }

    @Override
    public String toString() {

        return value;

    }

}
