package pe.com.rsolutionsit.controlpracticantes.common.security.principal;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Authenticated system user.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record AuthenticatedUser(

    UUID id,

    String username,

    String fullName,

    RoleCode roleCode

) {
}
