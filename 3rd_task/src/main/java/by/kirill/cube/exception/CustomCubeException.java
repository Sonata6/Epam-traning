package by.kirill.cube.exception;

import java.io.IOException;

public class CustomCubeException extends Exception {
    public CustomCubeException() {

        super();
    }

    public CustomCubeException(String message) {

        super(message);
    }

    public CustomCubeException(String message, Throwable cause) {

        super(message, cause);
    }

    public CustomCubeException(Throwable cause) {

        super(cause);
    }

    public CustomCubeException(IOException cause) {

        super(cause);
    }
}
