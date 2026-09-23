package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

import java.util.Optional;
import java.util.UUID;

/**
 * Internal JPA repository for roles.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public interface JpaRoleRepository extends JpaRepository<RoleEntity, UUID> {

    Optional<RoleEntity> findByCode(RoleCode code);

}
