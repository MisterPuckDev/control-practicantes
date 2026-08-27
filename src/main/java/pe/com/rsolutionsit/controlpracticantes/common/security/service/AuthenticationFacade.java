package pe.com.rsolutionsit.controlpracticantes.common.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Provides access to the current authentication.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Component
public class AuthenticationFacade {

    public Authentication getAuthentication() {

        return SecurityContextHolder

            .getContext()

            .getAuthentication();

    }

}
