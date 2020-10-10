package resources;
/**
 * Determina la excepción cuando no es encontrado un recurso. 
 */
public class ResourceNotFoundException extends Exception {

    
    private static final long serialVersionUID = -734139226522061245L;
    
    private String resourcePath;
    /**
     * Muestra la ruta del recurso
     * @param resourcePath Ruta del recurso
     */
    public ResourceNotFoundException(String resourcePath) {
        this.resourcePath = resourcePath;
    }
    /**
     * Muestra el mensaje de la excepción y la ruta donde debería estar.
     */
    public String toString() {
        return "The following resource path couldn't be found " + 
        "\n\n" + "Path:" + "[" + resourcePath + "]";
    }
    /**
     * Obtiene la ruta del recurso.
     * @return Devuelve la ruta del recurso
     */
    public String getResourcePath(){
        return resourcePath;
    }
}
