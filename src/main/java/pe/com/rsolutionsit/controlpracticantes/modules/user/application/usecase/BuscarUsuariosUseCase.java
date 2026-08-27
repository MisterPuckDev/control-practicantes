package pe.com.rsolutionsit.controlpracticantes.modules.user.application.usecase;

import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto.UsuarioResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto.UsuarioResponseMapper;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository.UsuarioRepository;

import java.util.List;

/**
 * Caso de uso encargado de obtener todos los usuarios del sistema.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */

@Service
public class BuscarUsuariosUseCase {

    private final UsuarioRepository repository;
    private final UsuarioResponseMapper mapper;

    public BuscarUsuariosUseCase(
        UsuarioRepository repository,
        UsuarioResponseMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Obtiene todos los usuarios registrados.
     *
     * @return lista de usuarios.
     */

    public List<UsuarioResponse> ejecutar() {

        return repository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }
}
