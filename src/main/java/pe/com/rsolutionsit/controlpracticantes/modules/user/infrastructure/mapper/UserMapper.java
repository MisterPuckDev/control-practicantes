package pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.persistence.RoleEntity;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.User;
import pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.persistence.UserEntity;

/**
 * Converts between persistence entities and domain models.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roleCode", source = "role.code")
    User toDomain(UserEntity entity);

    @Mapping(target = "role", ignore = true)
    UserEntity toEntity(User domain);

    default RoleCode map(RoleEntity roleEntity) {
        return roleEntity.getCode();
    }
}
