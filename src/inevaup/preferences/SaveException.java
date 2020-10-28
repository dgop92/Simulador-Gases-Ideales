package inevaup.preferences;

public class SaveException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -3075278040352788604L;
    
    private String saveErrorMessage;

    public SaveException(String saveErrorMessage) {
        this.saveErrorMessage = saveErrorMessage;
    }

    public String toString() {
        return saveErrorMessage;
    }

}
