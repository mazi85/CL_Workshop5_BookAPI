package pl.mazi85.exceptions;

public class NoSuchBookException extends RuntimeException{
    public NoSuchBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchBookException(String message) {
        super(message);
    }
}
