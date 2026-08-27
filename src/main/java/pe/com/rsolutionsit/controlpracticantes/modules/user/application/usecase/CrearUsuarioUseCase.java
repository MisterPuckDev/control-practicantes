package pe.com.rsolutionsit.controlpracticantes.modules.user.application.usecase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.Usuario;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository.UsuarioRepository;

/**
 * Caso de uso encargado de crear un usuario.
 * <p>
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
            RoleCode.ADMIN,
            true
        );

        return repository.save(usuario);
    }
}
