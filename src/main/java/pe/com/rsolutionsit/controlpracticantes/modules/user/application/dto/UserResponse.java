package pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Public user response.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record UserResponse(

    UUID id,

    String username,

    String fullName,

    String email,

    RoleCode roleCode,

    boolean active

) {
}
