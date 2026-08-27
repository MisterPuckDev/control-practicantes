package pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Solicitud de autenticación.
 */

public record LoginRequest(

    @NotBlank
    String username,

    @NotBlank
    String password

) {
}
