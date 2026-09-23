package pe.com.rsolutionsit.controlpracticantes.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Management endpoint configuration.
 *
 * <p>Provides typed access to health endpoint settings.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Validated
@ConfigurationProperties(prefix = "management.endpoint.health")
public class ManagementProperties {

    /**
     * Health detail visibility mode.
     */
    private String showDetails = "never";

    /**
     * Returns the configured visibility mode.
     *
     * @return visibility mode.
     */
    public String getShowDetails() {
        return showDetails;
    }

    /**
     * Updates the visibility mode.
     *
     * @param showDetails visibility mode.
     */
    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }
}
