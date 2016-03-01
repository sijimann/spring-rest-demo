package com.books.core.services.execeptions;

/**
 * Created by Simba on 2/28/2016.
 */
public class BookExistsException extends RuntimeException {
    public BookExistsException() {
    }

    public BookExistsException(String message) {
        super(message);
    }

    public BookExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookExistsException(Throwable cause) {
        super(cause);
    }
}
