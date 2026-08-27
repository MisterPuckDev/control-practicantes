package pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Authentication response.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record LoginResponse(

    String accessToken,

    String tokenType,

    UUID userId,

    String username,

    String fullName,

    RoleCode roleCode

) {
}
