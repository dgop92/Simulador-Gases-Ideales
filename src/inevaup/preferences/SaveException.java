package inevaup.preferences;

public class SaveException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -3075278040352788604L;
    
    public String toString() {
        return "Couldn't save the settings";
    }
}
