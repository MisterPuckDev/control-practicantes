package pe.com.rsolutionsit.controlpracticantes.common.config.properties;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Application-level configuration.
 *
 * <p>Centralizes global metadata shared across modules.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Validated
@ConfigurationProperties(prefix = "spring.application")
public class ApplicationProperties {

    /**
     * Application name.
     */
    @NotBlank
    private String name;

    /**
     * Returns the application name.
     *
     * @return application name.
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the application name.
     *
     * @param name application name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
