package pe.com.rsolutionsit.controlpracticantes.common.security.principal;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.Role;

/**
 * Representa al usuario autenticado del sistema.
 *
 * Esta clase desacopla el dominio de Spring Security.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record AuthenticatedUser(

    Long id,

    String username,

    String fullName,

    Role role

) {
}
