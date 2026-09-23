package pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Authentication request.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record LoginRequest(

    @NotBlank
    String username,

    @NotBlank
    String password

) {
}
