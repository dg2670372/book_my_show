package exception;



    // Default constructor
    public class SeatNotAvailableException extends Exception {

    // Default constructor
    public SeatNotAvailableException() {
        super("Seats are not available!");
    }

    // Custom message constructor
    public SeatNotAvailableException(String message) {
        super(message);
    }
}
