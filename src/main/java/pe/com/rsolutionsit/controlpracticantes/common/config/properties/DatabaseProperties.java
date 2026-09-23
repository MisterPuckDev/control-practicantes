package pe.com.rsolutionsit.controlpracticantes.common.config.properties;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Database configuration.
 *
 * <p>Provides typed access to application-specific database settings.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Validated
@ConfigurationProperties(prefix = "application.database")
public class DatabaseProperties {

    /**
     * Default application schema.
     */
    @NotBlank
    private String schema;

    /**
     * Returns the configured schema.
     *
     * @return database schema.
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Updates the configured schema.
     *
     * @param schema database schema.
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }
}
