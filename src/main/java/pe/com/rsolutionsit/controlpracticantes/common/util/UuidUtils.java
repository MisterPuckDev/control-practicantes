package pe.com.rsolutionsit.controlpracticantes.common.util;

import java.util.UUID;

/**
 * UUID helper utilities.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public final class UuidUtils {

    private UuidUtils() {
    }

    /**
     * Safely parses a UUID.
     */
    public static UUID parse(String value) {

        return UUID.fromString(value);
    }

    /**
     * Checks whether a value is a valid UUID.
     */
    public static boolean isValid(String value) {

        try {

            UUID.fromString(value);

            return true;

        } catch (IllegalArgumentException ex) {

            return false;

        }
    }
}
