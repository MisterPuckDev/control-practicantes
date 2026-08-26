package pe.com.rsolutionsit.controlpracticantes.common.exception;

/**
 * Excepción base para reglas de negocio.
 */
public abstract class BusinessException extends RuntimeException {

    protected BusinessException(String message) {
        super(message);
    }

    /**
     * Código identificador del error.
     */
    public abstract String getCode();

    /**
     * Código HTTP asociado.
     */
    public abstract int getStatus();
}