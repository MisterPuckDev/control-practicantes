package pe.com.rsolutionsit.controlpracticantes.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiResponse;

/**
 * Endpoint de verificación del estado del sistema.
 *
 * Permite comprobar rápidamente que la aplicación
 * se encuentra operativa.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@RestController
public class HealthController {

    /**
     * Devuelve el estado actual del sistema.
     *
     * @return respuesta indicando que el sistema está operativo.
     */
    @Operation(
            summary = "Estado del sistema",
            description = "Verifica que la aplicación esté funcionando correctamente."
    )
    @GetMapping("/health")
    public ApiResponse<String> health() {

        return ApiResponse.ok("Sistema operativo");
    }
}