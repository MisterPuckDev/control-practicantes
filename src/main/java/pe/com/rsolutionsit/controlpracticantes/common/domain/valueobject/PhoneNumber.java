package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

import java.util.Objects;

/**
 * Immutable phone number.
 *
 * @param value validated phone number.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record PhoneNumber(String value) {

    /**
     * Phone validation pattern.
     */
    private static final String PHONE_PATTERN =
        "^\\+?[0-9]{9,15}$";

    /**
     * Creates a validated phone number.
     *
     * @param value raw phone number.
     */
    public PhoneNumber {

        Objects.requireNonNull(value);

        value = value.trim();

        if (!value.matches(PHONE_PATTERN)) {

            throw new ValidationException(
                "Invalid phone number.");

        }
    }

    @Override
    public String toString() {

        return value;

    }

}
