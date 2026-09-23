package pe.com.rsolutionsit.controlpracticantes.common.security.principal;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.model.User;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Adapter between the domain User model and Spring Security.
 * <p>
 * Keeps Spring Security isolated from the domain layer.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
public final class UserPrincipal implements UserDetails {

    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    /**
     * Returns the user identifier.
     */
    public UUID getId() {
        return user.id();
    }

    /**
     * Returns the full name.
     */
    public String getFullName() {
        return user.fullName();
    }

    /**
     * Returns the wrapped domain object.
     */
    public User getDomainUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(
            new SimpleGrantedAuthority("ROLE_" + user.roleCode().name())
        );
    }

    @Override
    public String getPassword() {
        return user.password();
    }

    @Override
    public String getUsername() {
        return user.username();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.active();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.active();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.active();
    }

    @Override
    public boolean isEnabled() {
        return user.active();
    }
}
