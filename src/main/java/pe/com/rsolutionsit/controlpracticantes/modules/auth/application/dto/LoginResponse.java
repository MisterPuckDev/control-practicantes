package pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Authentication response.
 *
 * <p>Returns both access and refresh tokens together with the authenticated
 * user's public information.
 *
 * @param accessToken  access JWT.
 * @param refreshToken refresh JWT.
 * @param tokenType    token scheme.
 * @param userId       authenticated user identifier.
 * @param username     authenticated username.
 * @param fullName     authenticated full name.
 * @param roleCode     assigned role.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record LoginResponse(

    String accessToken,

    String refreshToken,

    String tokenType,

    UUID userId,

    String username,

    String fullName,

    RoleCode roleCode
) {
}
