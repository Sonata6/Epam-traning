package by.romanovich.task2.exception;

import java.io.IOException;

public class BankAccountException extends Exception {

    public BankAccountException() {

        super();
    }

    public BankAccountException(String message) {

        super(message);
    }

    public BankAccountException(String message, Throwable cause) {

        super(message, cause);
    }

    public BankAccountException(Throwable cause) {

        super(cause);
    }

    public BankAccountException(IOException cause) {

        super(cause);
    }
}
