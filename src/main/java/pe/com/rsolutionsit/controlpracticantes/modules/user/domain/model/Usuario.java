package pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

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

    UUID id,

    String username,

    String fullName,

    String email,

    String password,

    RoleCode roleCode,

    boolean active

) {
}
