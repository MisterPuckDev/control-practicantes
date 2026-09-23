package pe.com.rsolutionsit.controlpracticantes.common.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.principal.UserPrincipal;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository.UserRepository;

/**
 * Loads authenticated users from the application's persistence layer.
 *
 * <p>This service bridges Spring Security with the User module while keeping
 * authentication logic outside of the business domain.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * User repository.
     */
    private final UserRepository userRepository;

    /**
     * Creates the user details service.
     *
     * @param userRepository user repository.
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads a user by username.
     *
     * <p>The user must exist and be active.
     *
     * @param username username.
     * @return authenticated principal.
     * @throws UsernameNotFoundException if the user cannot be found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) {

        return userRepository.findByEmail(username)

            .map(UserPrincipal::new)

            .orElseThrow(() ->
                new UsernameNotFoundException(
                    "User not found."));
    }
}
