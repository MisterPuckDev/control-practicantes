package pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.persistence.JpaRoleRepository;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.User;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository.UserRepository;
import pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Connects the domain port with JPA persistence.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository userRepository;
    private final JpaRoleRepository roleRepository;
    private final UserMapper mapper;

    public UserRepositoryAdapter(
        JpaUserRepository userRepository,
        JpaRoleRepository roleRepository,
        UserMapper mapper) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;

    }

    @Override
    public User save(User user) {

        UserEntity entity = mapper.toEntity(user);

        entity.setRole(
            roleRepository.findByCode(user.roleCode())
                .orElseThrow());

        return mapper.toDomain(userRepository.save(entity));

    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
            .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
            .map(mapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
            .stream()
            .map(mapper::toDomain)
            .toList();
    }

    @Override
    public boolean existsAny() {
        return userRepository.count() > 0;
    }
}
