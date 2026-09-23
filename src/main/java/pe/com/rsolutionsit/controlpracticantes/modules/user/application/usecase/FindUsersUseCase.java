package pe.com.rsolutionsit.controlpracticantes.modules.user.application.usecase;

import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto.UserResponse;
import pe.com.rsolutionsit.controlpracticantes.modules.user.application.dto.UserResponseMapper;
import pe.com.rsolutionsit.controlpracticantes.modules.user.domain.repository.UserRepository;

import java.util.List;

/**
 * Retrieves all registered users.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Service
public class FindUsersUseCase {

    private final UserRepository repository;
    private final UserResponseMapper mapper;

    public FindUsersUseCase(
        UserRepository repository,
        UserResponseMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;

    }

    public List<UserResponse> execute() {

        return repository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();

    }
}
