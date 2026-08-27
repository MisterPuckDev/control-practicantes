package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import java.util.Objects;

/**
 * Immutable document number.
 * <p>
 * Represents only the document value.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record DocumentNumber(String value) {

    public DocumentNumber {

        Objects.requireNonNull(value);

        value = value.trim().toUpperCase();

        if (value.isBlank()) {
            throw new IllegalArgumentException(
                "Document number cannot be blank.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
