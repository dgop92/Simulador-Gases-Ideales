package inevaup.resources;
/**
 * Excepción para cuando un recurso no es encontrado
 */
public class ResourceNotFoundException extends Exception {

    
    private static final long serialVersionUID = -734139226522061245L;
    private String resourcePath;

    /**
     * Construye la excepcion con la respectiva ruta del recurso
     * 
     * @param resourcePath Ruta del recurso no econtrado
     */
    public ResourceNotFoundException(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     * Muestra el mensaje de la excepción y la ruta donde debería estar
     * 
     * @return Un {@code string} con el mensaje de error de la excepcion
     */
    public String toString() {
        return "The following resource path couldn't be found " + 
        "\n\n" + "Path:  " + "[" + resourcePath + "]";
    }

    /**
     * Obtener la ruta del recurso.
     * 
     * @return La ruta del recurso
     */
    public String getResourcePath(){
        return resourcePath;
    }
}
