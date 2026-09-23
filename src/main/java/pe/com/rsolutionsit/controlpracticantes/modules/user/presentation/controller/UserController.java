package pe.com.rsolutionsit.controlpracticantes.modules.user.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto.UserResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.user.application.usecase.FindUsersUseCase;

import java.util.List;

/**
 * User REST controller.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "System user management")
public class UserController {

    private final FindUsersUseCase useCase;

    public UserController(FindUsersUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(summary = "List users")
    @GetMapping
    public ApiResponse<List<UserResponse>> findAll() {

        return ApiResponse.ok(useCase.execute());

    }
}
