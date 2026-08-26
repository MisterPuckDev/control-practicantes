package pe.com.rsolutionsit.controlpracticantes.modules.usuario.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.application.dto.UsuarioResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.application.usecase.BuscarUsuariosUseCase;

import java.util.List;

/**
 * Controlador REST del módulo Usuario.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Gestión de usuarios del sistema")
public class UsuarioController {

    private final BuscarUsuariosUseCase useCase;

    public UsuarioController(BuscarUsuariosUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Obtiene todos los usuarios.
     */
    @Operation(
        summary = "Listar usuarios",
        description = "Devuelve todos los usuarios registrados."
    )
    @GetMapping
    public ApiResponse<List<UsuarioResponse>> listar() {

        return ApiResponse.ok(useCase.ejecutar());
    }
}
