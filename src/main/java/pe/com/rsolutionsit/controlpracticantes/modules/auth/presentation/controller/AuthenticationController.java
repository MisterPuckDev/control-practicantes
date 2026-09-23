package pe.com.rsolutionsit.controlpracticantes.modules.auth.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto.LoginRequest;
import pe.com.rsolutionsit.controlpracticantes.modules.auth.application.dto.LoginResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.auth.application.usecase.LoginUseCase;

/**
 * Authentication endpoints.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@RestController
@RequestMapping("/v1/auth")
@Tag(name = "Authentication")
public class AuthenticationController {

    private final LoginUseCase loginUseCase;

    public AuthenticationController(LoginUseCase loginUseCase) {

        this.loginUseCase = loginUseCase;
    }

    @Operation(summary = "Authenticate user")
    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(
        @Valid @RequestBody LoginRequest request) {

        return ApiResponse.ok(

            loginUseCase.execute(request)

        );
    }
}
