package pe.com.rsolutionsit.controlpracticantes.modules.usuario.application.usecase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.Role;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.model.Usuario;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.repository.UsuarioRepository;

/**
 * Caso de uso encargado de crear un usuario.
 *
 * Centraliza la creación y el cifrado de contraseñas.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Service
public class CrearUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public CrearUsuarioUseCase(
        UsuarioRepository repository,
        PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Crea un usuario administrador.
     */
    public Usuario crearAdministrador(
        String username,
        String fullName,
        String email,
        String password) {

        Usuario usuario = new Usuario(
            null,
            username,
            fullName,
            email,
            passwordEncoder.encode(password),
            Role.ADMIN,
            true
        );

        return repository.save(usuario);
    }
}
