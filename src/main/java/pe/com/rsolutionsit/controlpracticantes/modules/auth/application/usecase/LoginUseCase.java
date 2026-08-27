package pe.com.rsolutionsit.controlpracticantes.modules.auth.application.usecase;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.jwt.JwtService;
import pe.com.rsolutionsit.controlpracticantes.common.security.principal.UserPrincipal;
import pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto.LoginRequest;
import pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto.LoginResponse;

/**
 * Performs user authentication.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Service
public class LoginUseCase {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public LoginUseCase(
        AuthenticationManager authenticationManager,
        JwtService jwtService) {

        this.authenticationManager = authenticationManager;

        this.jwtService = jwtService;
    }

    public LoginResponse execute(LoginRequest request) {

        var authentication = authenticationManager.authenticate(

            new UsernamePasswordAuthenticationToken(

                request.username(),

                request.password()

            )

        );

        UserPrincipal principal =
            (UserPrincipal) authentication.getPrincipal();

        String token = jwtService.generateToken(principal);

        return new LoginResponse(

            token,

            "Bearer",

            principal.getId(),

            principal.getUsername(),

            principal.getFullName(),

            principal.getDomainUser().roleCode()

        );
    }
}
