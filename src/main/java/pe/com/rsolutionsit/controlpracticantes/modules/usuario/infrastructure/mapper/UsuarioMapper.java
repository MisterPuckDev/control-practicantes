package pe.com.rsolutionsit.controlpracticantes.modules.usuario.infrastructure.mapper;

import org.mapstruct.Mapper;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.model.Usuario;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.infrastructure.persistence.UsuarioEntity;

/**
 * Convierte entre el modelo de dominio y la entidad persistente.
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toDomain(UsuarioEntity entity);

    UsuarioEntity toEntity(Usuario domain);
}
