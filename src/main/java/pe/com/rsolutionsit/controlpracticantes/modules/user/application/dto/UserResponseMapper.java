package pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto;

import org.mapstruct.Mapper;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.User;

/**
 * Converts domain users into API responses.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponse toResponse(User user);

}
