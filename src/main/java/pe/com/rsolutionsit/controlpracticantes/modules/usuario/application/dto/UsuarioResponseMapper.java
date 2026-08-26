package pe.com.rsolutionsit.controlpracticantes.modules.usuario.application.dto;

import org.mapstruct.Mapper;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.model.Usuario;

/**
 * Convierte el modelo de dominio hacia el DTO de respuesta.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface UsuarioResponseMapper {

    UsuarioResponse toResponse(Usuario usuario);

}
