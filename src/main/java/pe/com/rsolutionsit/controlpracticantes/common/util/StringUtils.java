package pe.com.rsolutionsit.controlpracticantes.common.util;

/**
 * String helper utilities.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * Returns true when the value is null or blank.
     */
    public static boolean isBlank(String value) {

        return value == null || value.isBlank();
    }

    /**
     * Returns true when the value has content.
     */
    public static boolean hasText(String value) {

        return !isBlank(value);
    }

    /**
     * Normalizes whitespace.
     */
    public static String normalize(String value) {

        if (isBlank(value)) {

            return "";

        }

        return value.trim().replaceAll("\s+", " ");
    }
}
