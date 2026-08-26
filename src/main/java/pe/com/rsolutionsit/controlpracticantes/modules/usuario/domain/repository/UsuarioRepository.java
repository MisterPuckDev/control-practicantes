package pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.repository;

import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Puerto del dominio para acceder a usuarios.
 */
public interface UsuarioRepository {

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();
}
