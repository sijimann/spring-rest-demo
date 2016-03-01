package com.books.core.services.execeptions;

/**
 * Created by Simba on 2/28/2016.
 */
public class BookNotFoundException extends RuntimeException  {
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException() {
    }
}
