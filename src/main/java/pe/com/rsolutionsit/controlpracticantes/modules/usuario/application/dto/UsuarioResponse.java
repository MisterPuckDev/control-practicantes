package pe.com.rsolutionsit.controlpracticantes.modules.usuario.application.dto;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.Role;

/**
 * DTO utilizado para exponer información pública del usuario.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record UsuarioResponse(

    Long id,

    String username,

    String fullName,

    String email,

    Role role,

    boolean active

) {
}
