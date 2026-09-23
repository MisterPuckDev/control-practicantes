package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.domain.model.Role;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.domain.repository.RoleRepository;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.mapper.RoleMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Adapter connecting the domain port with JPA persistence.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Repository
public class RoleRepositoryAdapter implements RoleRepository {

    private final JpaRoleRepository jpaRepository;
    private final RoleMapper mapper;

    public RoleRepositoryAdapter(
        JpaRoleRepository jpaRepository,
        RoleMapper mapper) {

        this.jpaRepository = jpaRepository;
        this.mapper = mapper;

    }

    @Override
    public Optional<Role> findById(UUID id) {

        return jpaRepository.findById(id)
            .map(mapper::toDomain);

    }

    @Override
    public Optional<Role> findByCode(RoleCode code) {

        return jpaRepository.findByCode(code)
            .map(mapper::toDomain);

    }

    @Override
    public List<Role> findAll() {

        return jpaRepository.findAll()
            .stream()
            .map(mapper::toDomain)
            .toList();

    }
}
