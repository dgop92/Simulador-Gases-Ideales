package resources;
/**
 * Determina la excepción cuando no es cargado un recurso. 
 */
public class ResourceNotLoadedException extends Exception{

   
    private static final long serialVersionUID = -7444763484093796584L;
    
    private String reason;
    private String resourcePath;
    /**
     * Genera las diferentes razones para cada excepción. 
     * @param resourcePath Ruta del recurso
     * @param reason Razón
     */
    public ResourceNotLoadedException(String resourcePath, String reason) {
        this.resourcePath = resourcePath;
        this.reason = reason;
    }
    /**
     * Determina cuando ocurre un error inesperado.
     * @param resourcePath Ruta del recurso
     */
    public ResourceNotLoadedException(String resourcePath) {
        this.resourcePath = resourcePath;
        this.reason = "Unexpected reason";
    }
    /**
     * Devuelve la ruta del recurso no cargado y añade la razón. 
     */
    public String toString() {
        return "The following resource path couldn't be loaded " + "[" + resourcePath + "]" +
            "\n\n" + "Reason: " + reason;
    }
}
