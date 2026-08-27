package pe.com.rsolutionsit.controlpracticantes.common.security.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * Supplies the authenticated user for JPA auditing.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Component
public class SecurityAuditor implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor() {

        return Optional.empty();

    }

}
