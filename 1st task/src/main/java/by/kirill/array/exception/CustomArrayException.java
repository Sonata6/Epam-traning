package by.kirill.array.exception;

import java.io.IOException;

public class CustomArrayException extends Exception {

    public CustomArrayException() {

        super();
    }

    public CustomArrayException(String message) {

        super(message);
    }

    public CustomArrayException(String message, Throwable cause) {

        super(message, cause);
    }

    public CustomArrayException(Throwable cause) {

        super(cause);
    }

    public CustomArrayException(IOException cause) {

        super(cause);
    }
}
