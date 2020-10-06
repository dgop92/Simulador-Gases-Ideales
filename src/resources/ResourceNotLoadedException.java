package resources;
/**
 * Esta clase se determina los errores y las razones cuando los recursos no están totalmente cargados. 
 */
public class ResourceNotLoadedException extends Exception{

   
    private static final long serialVersionUID = -7444763484093796584L;
    
    private String reason;
    private String resourcePath;
    /**
     *  Esta función genera las diferentes razones. 
     * @param resourcePath
     * @param reason
     */
    public ResourceNotLoadedException(String resourcePath, String reason) {
        this.resourcePath = resourcePath;
        this.reason = reason;
    }
    /**
     * Esta función determina cuando es un error inexplicable.
     * @param resourcePath
     */
    public ResourceNotLoadedException(String resourcePath) {
        this.resourcePath = resourcePath;
        this.reason = "Unexpected reason";
    }
    /**
     * Esta función muestra la rasón más la ruta de ubicación del recurso no cargado. 
     */
    public String toString() {
        return "The following resource path couldn't be loaded " + "[" + resourcePath + "]" +
            "\n\n" + "Reason: " + reason;
    }
}
