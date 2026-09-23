package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.domain.model;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.UUID;

/**
 * Domain representation of a system role.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record Role(

  UUID id,

  RoleCode code,

  String name

) {
}
