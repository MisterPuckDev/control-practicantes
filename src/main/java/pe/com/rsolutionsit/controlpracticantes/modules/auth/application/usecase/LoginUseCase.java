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
 * @author Raul Sosa
 * @since 1.0.0
 */
@Service
public class LoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    /**
     * Creates the login use case.
     *
     * @param authenticationManager authentication manager.
     * @param jwtService            JWT service.
     */
    public LoginUseCase(
        AuthenticationManager authenticationManager,
        JwtService jwtService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    /**
     * Authenticates the user.
     *
     * @param request login request.
     * @return authentication response.
     */
    public LoginResponse execute(LoginRequest request) {

        var authentication = authenticationManager.authenticate(

            new UsernamePasswordAuthenticationToken(

                request.username(),

                request.password()));

        UserPrincipal principal =
            (UserPrincipal) authentication.getPrincipal();

        String accessToken =
            jwtService.generateAccessToken(principal);

        String refreshToken =
            jwtService.generateRefreshToken(principal);

        return new LoginResponse(

            accessToken,

            refreshToken,

            "Bearer",

            principal.getId(),

            principal.getUsername(),

            principal.getFullName(),

            principal.getDomainUser().roleCode());

    }
}
