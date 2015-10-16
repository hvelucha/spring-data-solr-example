package au.edu.parentPortal.fixtures;

/**
 * Created by hveluchamy on 27/11/2014.
 */
public class FailureException extends RuntimeException{
    public FailureException() {
        super();
    }

    public FailureException(String message) {
        super(message);
    }

    public FailureException(Exception e) {
        super(e);
    }

    public FailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
