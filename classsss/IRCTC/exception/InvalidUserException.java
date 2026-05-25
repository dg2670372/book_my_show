package exception;

public class InvalidUserException extends Exception {

    // Default constructor
    public InvalidUserException() {
        super("Invalid email or password!");
    }

    // Custom message constructor
    public InvalidUserException(String message) {
        super(message);
    }
}