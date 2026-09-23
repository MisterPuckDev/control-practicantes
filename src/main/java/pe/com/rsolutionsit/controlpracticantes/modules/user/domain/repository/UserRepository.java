package pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository;

import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Domain port for user persistence.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public interface UserRepository {

    User save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    boolean existsAny();

}
