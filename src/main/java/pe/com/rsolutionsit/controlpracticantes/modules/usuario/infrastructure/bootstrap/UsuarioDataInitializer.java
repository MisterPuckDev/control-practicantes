package pe.com.rsolutionsit.controlpracticantes.modules.usuario.infrastructure.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.application.usecase.CrearUsuarioUseCase;
import pe.com.rsolutionsit.controlpracticantes.modules.usuario.domain.repository.UsuarioRepository;

/**
 * Inicializa datos básicos del módulo Usuario.
 *
 * Crea un administrador únicamente cuando no existen usuarios.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Component
@Profile("dev")
public class UsuarioDataInitializer implements CommandLineRunner {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(UsuarioDataInitializer.class);

    private final UsuarioRepository repository;
    private final CrearUsuarioUseCase crearUsuarioUseCase;

    public UsuarioDataInitializer(
        UsuarioRepository repository,
        CrearUsuarioUseCase crearUsuarioUseCase) {

        this.repository = repository;
        this.crearUsuarioUseCase = crearUsuarioUseCase;
    }

    @Override
    public void run(String... args) {

        if (repository.existsAny()) {

            LOGGER.info("Bootstrap omitido: ya existen usuarios.");
            return;
        }

        crearUsuarioUseCase.crearAdministrador(
            "admin",
            "Administrador del Sistema",
            "admin@rsolutionsit.pe",
            "Admin123*"
        );

        LOGGER.info("Usuario administrador inicial creado.");
    }
}
