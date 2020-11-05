package interfaces.forms;

public class ValidationError extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String reason;

    public ValidationError(String reason) {
        this.reason = reason;
    }

    public String toString() {
        return reason;
    }

    public String getReason() {
        return reason;
    }

    
}
