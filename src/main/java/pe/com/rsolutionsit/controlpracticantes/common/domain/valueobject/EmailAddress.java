package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Immutable email value object.
 *
 * @param value normalized email.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record EmailAddress(String value) {

    /**
     * Email validation pattern.
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$");

    /**
     * Creates a validated email.
     *
     * @param value raw email.
     */
    public EmailAddress {

        Objects.requireNonNull(value);

        value = value.trim().toLowerCase();

        if (!EMAIL_PATTERN.matcher(value).matches()) {

            throw new ValidationException(
                "Invalid email address.");

        }
    }

    @Override
    public String toString() {

        return value;

    }

}
