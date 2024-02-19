package Exeptions;

public class WrongInfoException extends Exception{
    public WrongInfoException() {
    }

    public WrongInfoException(String message) {
        super(message);
    }
}
