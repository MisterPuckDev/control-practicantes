package pe.com.rsolutionsit.controlpracticantes.common.security.principal;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Immutable authenticated user used by the JWT module.
 *
 * <p>This record represents the minimum identity information required to
 * generate security tokens without coupling the JWT layer to Spring Security.
 *
 * @param id       authenticated user identifier.
 * @param username authenticated username.
 * @param fullName user full name.
 * @param roleCode assigned role.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record AuthenticatedUser(

    UUID id,

    String username,

    String fullName,

    RoleCode roleCode

) {
}
