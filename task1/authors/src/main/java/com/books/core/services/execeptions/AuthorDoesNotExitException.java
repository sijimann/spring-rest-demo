package com.books.core.services.execeptions;

/**
 * Created by Simba on 2/28/2016.
 */
public class AuthorDoesNotExitException extends RuntimeException {
    public AuthorDoesNotExitException(Throwable cause) {
        super(cause);
    }

    public AuthorDoesNotExitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorDoesNotExitException(String message) {
        super(message);
    }

    public AuthorDoesNotExitException() {
    }
}
