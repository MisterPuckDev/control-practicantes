package pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository;

import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto del dominio para acceder a usuarios.
 */

public interface UsuarioRepository {

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(UUID id);

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();

    boolean existsAny();

}
