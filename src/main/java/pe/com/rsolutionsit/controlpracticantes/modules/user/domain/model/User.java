package pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Domain representation of a system user.
 * <p>
 * This model contains only business information and remains
 * independent from Spring and JPA.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record User(

    UUID id,

    String username,

    String fullName,

    String email,

    String password,

    RoleCode roleCode,

    boolean active

) {
}
