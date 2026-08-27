package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.domain.repository;

import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;
import pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.domain.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Domain port for role persistence.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public interface RoleRepository {

    Optional<Role> findById(UUID id);

    Optional<Role> findByCode(RoleCode code);

    List<Role> findAll();

}
