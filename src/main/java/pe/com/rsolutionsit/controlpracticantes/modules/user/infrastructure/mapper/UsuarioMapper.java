    package pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.mapper;

    import org.mapstruct.Mapper;
    import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.Usuario;
    import pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.persistence.UsuarioEntity;

    /**
     * Convierte entre el modelo de dominio y la entidad persistente.
     */

    @Mapper(componentModel = "spring")
    public interface UsuarioMapper {

        Usuario toDomain(UsuarioEntity entity);

        UsuarioEntity toEntity(Usuario domain);

    }
