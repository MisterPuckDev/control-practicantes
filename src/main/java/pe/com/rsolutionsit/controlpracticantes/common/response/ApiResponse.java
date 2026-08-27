package pe.com.rsolutionsit.controlpracticantes.common.response;

import java.time.LocalDateTime;

/**

 Standard successful API response.


 @param success operation status.
 @param data response payload.
 @param timestamp response creation timestamp.
 @param <T> payload type.


 @author MisterPuckDev

 @since 1.0.0
 */
public record ApiResponse<T>(

    boolean success,

    T data,

    LocalDateTime timestamp

) {

    /**
     * Creates a successful response.
     *
     * @param data response payload.
     * @return successful response.
     */
    public static <T> ApiResponse<T> ok(T data) {

        return new ApiResponse<>(
            true,
            data,
            LocalDateTime.now()
        );
    }

    /**
     * Creates an empty successful response.
     *
     * @return successful response without payload.
     */
    public static ApiResponse<Void> empty() {

        return new ApiResponse<>(
            true,
            null,
            LocalDateTime.now()
        );
    }

}
