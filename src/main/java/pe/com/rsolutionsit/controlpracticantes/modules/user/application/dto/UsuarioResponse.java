package pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto;

import java.util.UUID;

/**
 * DTO utilizado para exponer información pública del usuario.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */

public record UsuarioResponse(

    UUID id,

    String username,

    String fullName,

    String email,

    RoleCode roleCode,

    boolean active

) {
}
