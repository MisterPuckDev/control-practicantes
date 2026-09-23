package pe.com.rsolutionsit.controlpracticantes.common.response;

import java.time.LocalDateTime;

/**
 * Standard successful API response.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record ApiResponse<T>(

    boolean success,

    String message,

    T data,

    LocalDateTime timestamp

) {


    /**
     * Successful response with payload.
     */
    public static <T> ApiResponse<T> ok(T data) {

        return new ApiResponse<>(

            true,

            "Operation completed successfully.",

            data,

            LocalDateTime.now()

        );
    }

    /**
     * Successful response with custom message.
     */
    public static <T> ApiResponse<T> ok(
        String message,
        T data) {

        return new ApiResponse<>(

            true,

            message,

            data,

            LocalDateTime.now()

        );
    }

    /**
     * Empty successful response.
     */
    public static ApiResponse<Void> empty(String message) {

        return new ApiResponse<>(

            true,

            message,

            null,

            LocalDateTime.now()

        );
    }

}
