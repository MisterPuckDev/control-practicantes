package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

import java.util.Objects;

/**
 * Immutable username value object.
 *
 * <p>Usernames are normalized before validation and must follow the official
 * application naming rules.
 *
 * @param value normalized username.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record Username(String value) {

    /**
     * Minimum username length.
     */
    private static final int MIN_LENGTH = 3;

    /**
     * Maximum username length.
     */
    private static final int MAX_LENGTH = 50;

    /**
     * Allowed username pattern.
     */
    private static final String USERNAME_PATTERN =
        "^[a-zA-Z0-9._-]+$";

    /**
     * Creates a validated username.
     *
     * @param value raw username.
     */
    public Username {

        Objects.requireNonNull(value);

        value = value.trim();

        if (value.length() < MIN_LENGTH
            || value.length() > MAX_LENGTH) {

            throw new ValidationException(
                "Username must contain between 3 and 50 characters.");

        }

        if (!value.matches(USERNAME_PATTERN)) {

            throw new ValidationException(
                "Username contains invalid characters.");

        }
    }

    @Override
    public String toString() {

        return value;

    }

}
