package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.mapper;

import org.mapstruct.Mapper;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.domain.model.Role;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.persistence.RoleEntity;

/**
 * Converts persistence entities into domain models.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toDomain(RoleEntity entity);

    RoleEntity toEntity(Role role);

}
