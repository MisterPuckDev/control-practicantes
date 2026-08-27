package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.application.dto;

import org.mapstruct.Mapper;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.domain.model.Role;

/**
 * Converts domain roles into API responses.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Mapper(componentModel = "spring")
public interface RoleResponseMapper {

    RoleResponse toResponse(Role role);

}
