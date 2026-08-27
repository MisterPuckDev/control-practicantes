package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

import java.util.Objects;

/**
 * Immutable phone number.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record PhoneNumber(String value) {

    public PhoneNumber {

        Objects.requireNonNull(value);

        value = value.trim();

        if (!value.matches("^\\+?[0-9]{9,15}$")) {

            throw new ValidationException(
                "Invalid phone number.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
