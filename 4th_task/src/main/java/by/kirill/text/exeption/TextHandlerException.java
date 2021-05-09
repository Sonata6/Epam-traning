package by.kirill.text.exeption;

public class TextHandlerException extends Exception {
    public TextHandlerException() {
        super();
    }

    public TextHandlerException(String message) {
        super(message);
    }

    public TextHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextHandlerException(Throwable cause) {
        super(cause);
    }
}
