package pe.com.rsolutionsit.controlpracticantes.common.security.principal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository.UserRepository;

/**
 * Loads users for Spring Security authentication.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Service
public class UserPrincipalService implements UserDetailsService {

    private final UserRepository repository;

    public UserPrincipalService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {

        return repository.findByUsername(username)
            .map(UserPrincipal::new)
            .orElseThrow(() ->
                new UsernameNotFoundException(
                    "User not found: " + username));
    }
}
