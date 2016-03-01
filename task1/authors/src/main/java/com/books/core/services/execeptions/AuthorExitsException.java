package com.books.core.services.execeptions;

/**
 * Created by Simba on 2/28/2016.
 */
public class AuthorExitsException extends RuntimeException {
    public AuthorExitsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorExitsException(String message) {
        super(message);
    }

    public AuthorExitsException() {
        super();
    }
}
