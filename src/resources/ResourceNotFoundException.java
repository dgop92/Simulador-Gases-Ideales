package resources;

public class ResourceNotFoundException extends Exception {

    private String resourcePath;

    public ResourceNotFoundException(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String toString() {
        return "The following resource path couldn't be found " + "[" + resourcePath + "]";
    }

    public String getResourcePath(){
        return resourcePath;
    }
}
