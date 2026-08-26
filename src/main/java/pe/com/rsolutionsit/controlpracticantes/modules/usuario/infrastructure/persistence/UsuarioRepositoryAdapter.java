package pe.com.rsolutionsit.controlpracticantes.modules.usuario.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.model.Usuario;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.repository.UsuarioRepository;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.infrastructure.mapper.UsuarioMapper;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador que conecta el puerto del dominio con la persistencia JPA.
 *
 * Esta clase es el único componente del módulo que conoce simultáneamente
 * el dominio, JPA y MapStruct.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final JpaUsuarioRepository jpaRepository;
    private final UsuarioMapper mapper;

    public UsuarioRepositoryAdapter(
        JpaUsuarioRepository jpaRepository,
        UsuarioMapper mapper) {

        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepository.findById(id)
            .map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return jpaRepository.findByUsername(username)
            .map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
            .map(mapper::toDomain);
    }

    @Override
    public List<Usuario> findAll() {
        return jpaRepository.findAll()
            .stream()
            .map(mapper::toDomain)
            .toList();
    }
}
