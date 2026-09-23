package pe.com.rsolutionsit.controlpracticantes.common.domain.valueobject;

import pe.com.rsolutionsit.controlpracticantes.common.exception.ValidationException;

/**
 * Immutable document value object.
 * <p>
 * Encapsulates validation rules according
 * to the selected document type.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record Document(

    DocumentType type,

    DocumentNumber number

) {

    public Document {

        validate(type, number.value());
    }

    private static void validate(
        DocumentType type,
        String value) {

        switch (type) {

            case DNI -> {

                if (!value.matches("\\d{8}")) {

                    throw new ValidationException(
                        "DNI must contain exactly 8 digits.");
                }
            }

            case CE -> {

                if (!value.matches("[A-Z0-9]{9,12}")) {

                    throw new ValidationException(
                        "Foreign ID must contain between 9 and 12 alphanumeric characters.");
                }
            }

            case PASSPORT -> {

                if (!value.matches("[A-Z0-9]{6,12}")) {

                    throw new ValidationException(
                        "Passport must contain between 6 and 12 alphanumeric characters.");
                }
            }
        }
    }

    @Override
    public String toString() {

        return type + " " + number;
    }
}
