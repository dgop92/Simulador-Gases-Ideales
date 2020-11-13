package inevaup.resources;
/**
 * Excepción para cuando un recurso no se puede cargar
 */
public class ResourceNotLoadedException extends Exception{

   
    private static final long serialVersionUID = -7444763484093796584L;
    
    private final String reason;
    private final String resourcePath;

    /**
     * Construye la excepcion con sus respectivos parametros
     * 
     * @param resourcePath Ruta del recurso
     * @param reason Razon por la cual el recurso no se cargo
     */
    public ResourceNotLoadedException(String resourcePath, String reason) {
        this.resourcePath = resourcePath;
        this.reason = reason;
    }

    /**
     * Construye la excepcion con la ruta del recurso pero sin razon
     * 
     * @param resourcePath Ruta del recurso
     */
    public ResourceNotLoadedException(String resourcePath) {
        this.resourcePath = resourcePath;
        this.reason = "Unexpected reason";
    }

    /**
     * Muestra el mensaje de la excepción con la ruta y la razon por la cual fallo al cargar
     * 
     * @return Un {@code string} con el mensaje de error de la excepcion
     */
    @Override
    public String toString() {
        return "The following resource path couldn't be loaded " + "[" + resourcePath + "]" +
            "\n\n" + "Reason: " + reason;
    }
}
