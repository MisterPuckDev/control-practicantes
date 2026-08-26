package pe.com.rsolutionsit.controlpracticantes.common.response;

import java.time.LocalDateTime;

/**
 * Respuesta estándar para operaciones exitosas de la API.
 *
 * @param <T> tipo del dato devuelto.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record ApiResponse<T>(
        boolean success,
        T data,
        LocalDateTime timestamp
) {

    /**
     * Crea una respuesta exitosa con datos.
     *
     * @param data información a devolver.
     * @return respuesta exitosa.
     */
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(
                true,
                data,
                LocalDateTime.now()
        );
    }

    /**
     * Crea una respuesta exitosa sin contenido.
     *
     * @return respuesta exitosa vacía.
     */
    public static ApiResponse<Void> empty() {
        return new ApiResponse<>(
                true,
                null,
                LocalDateTime.now()
        );
    }
}