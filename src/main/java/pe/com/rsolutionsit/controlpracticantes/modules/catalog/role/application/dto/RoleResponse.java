package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.application.dto;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Public role response.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record RoleResponse(

    UUID id,

    RoleCode code,

    String name

) {
}
