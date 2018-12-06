package com.elu.canoo.library.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String id) {
        super("Could not find book with id " + id);
    }
}
