package pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Internal JPA repository for users.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

}
