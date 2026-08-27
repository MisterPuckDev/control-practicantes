package pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

/**
 * Respuesta del proceso de autenticación.
 */

public record LoginResponse(

    String token,

    String tokenType,

    Long userId,

    String username,

    String fullName,

    RoleCode roleCode

) {
}
