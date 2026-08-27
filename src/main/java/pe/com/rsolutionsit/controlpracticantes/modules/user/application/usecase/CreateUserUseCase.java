package pe.com.rsolutionsit.controlpracticantes.modules.user.application.usecase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.User;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository.UserRepository;

/**
 * Creates system users.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Service
public class CreateUserUseCase {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserUseCase(
        UserRepository repository,
        PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;

    }

    public User createAdministrator(
        String username,
        String fullName,
        String email,
        String password) {

        User user = new User(
            null,
            username,
            fullName,
            email,
            passwordEncoder.encode(password),
            RoleCode.ADMIN,
            true
        );

        return repository.save(user);

    }
}
