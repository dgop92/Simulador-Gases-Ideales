package resources;

public class ResourceNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -734139226522061245L;
    
    private String resourcePath;

    public ResourceNotFoundException(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String toString() {
        return "The following resource path couldn't be found " + 
        "\n\n" + "Path:" + "[" + resourcePath + "]";
    }

    public String getResourcePath(){
        return resourcePath;
    }
}
