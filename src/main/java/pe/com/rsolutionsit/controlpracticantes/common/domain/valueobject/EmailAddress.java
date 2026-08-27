package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

import java.util.Objects;

/**
 * Immutable email value object.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record EmailAddress(String value) {

    private static final String EMAIL_REGEX =
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public EmailAddress {

        Objects.requireNonNull(value);

        value = value.trim().toLowerCase();

        if (!value.matches(EMAIL_REGEX)) {

            throw new ValidationException(
                "Invalid email address.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
