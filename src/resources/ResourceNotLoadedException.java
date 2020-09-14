package resources;

public class ResourceNotLoadedException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -7444763484093796584L;
    
    private String reason;
    private String resourcePath;

    public ResourceNotLoadedException(String resourcePath, String reason) {
        this.resourcePath = resourcePath;
        this.reason = reason;
    }

    public ResourceNotLoadedException(String resourcePath) {
        this.resourcePath = resourcePath;
        this.reason = "Unexpected reason";
    }

    public String toString() {
        return "The following resource path couldn't be loaded " + "[" + resourcePath + "]" +
            "\n\n" + "Reason: " + reason;
    }
}
