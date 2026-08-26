package pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.model;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.Role;

/**
 * Representa el usuario del dominio.
 *
 * Esta clase contiene únicamente información de negocio y
 * no depende de JPA ni de Spring Security.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public record Usuario(

    Long id,

    String username,

    String fullName,

    String email,

    String password,

    Role role,

    boolean active

) {
}
