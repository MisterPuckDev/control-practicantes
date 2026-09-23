package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;
import pe.com.rsolutionsit.controlpracticantes.common.util.StringUtils;

import java.util.Objects;

/**
 * Immutable full name value object.
 *
 * <p>Names are normalized before validation.
 *
 * @param value normalized full name.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record FullName(String value) {

    /**
     * Maximum name length.
     */
    private static final int MAX_LENGTH = 120;

    /**
     * Creates a validated full name.
     *
     * @param value raw full name.
     */
    public FullName {

        Objects.requireNonNull(value);

        value = StringUtils.normalize(value);

        if (value.isBlank()) {

            throw new ValidationException(
                "Full name cannot be blank.");

        }

        if (value.length() > MAX_LENGTH) {

            throw new ValidationException(
                "Full name exceeds the maximum allowed length.");

        }
    }

    @Override
    public String toString() {

        return value;

    }

}
