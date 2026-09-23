package pe.com.rsolutionsit.controlpracticantes.common.security.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pe.com.rsolutionsit.controlpracticantes.common.security.principal.UserPrincipal;

import java.util.Optional;
import java.util.UUID;

/**
 * Supplies the authenticated user for JPA auditing.
 *
 * <p>The current authenticated user's UUID is automatically written into
 * created_by and updated_by audit fields.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Component("securityAuditor")
public class SecurityAuditor implements AuditorAware<UUID> {

    /**
     * Returns the current authenticated user's identifier.
     *
     * @return authenticated user UUID when available.
     */
    @Override
    public Optional<UUID> getCurrentAuditor() {

        Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null
            || !authentication.isAuthenticated()
            || authentication.getPrincipal().equals("anonymousUser")) {

            return Optional.empty();

        }

        if (authentication.getPrincipal() instanceof UserPrincipal principal) {

            return Optional.of(principal.getId());

        }

        return Optional.empty();
    }
}
