package com.example.demo.exception;

public class UserIdMismatchException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 591827758281906602L;

    public UserIdMismatchException() {
	super();
    }

    public UserIdMismatchException(final String message, final Throwable cause) {
	super(message, cause);
    }

    public UserIdMismatchException(final String message) {
	super(message);
    }

    public UserIdMismatchException(final Throwable cause) {
	super(cause);
    }
}