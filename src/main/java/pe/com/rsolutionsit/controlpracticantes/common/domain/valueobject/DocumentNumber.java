package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

import java.util.Objects;

/**
 * Immutable document number.
 *
 * @param value normalized document number.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record DocumentNumber(String value) {

    /**
     * Creates a normalized document number.
     *
     * @param value raw document number.
     */
    public DocumentNumber {

        Objects.requireNonNull(value);

        value = value.trim().toUpperCase();

        if (value.isBlank()) {

            throw new ValidationException(
                "Document number cannot be blank.");

        }
    }

    @Override
    public String toString() {

        return value;

    }

}
