package Exeptions;

public class AlreadyExistException extends Exception {
    public AlreadyExistException() {
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
