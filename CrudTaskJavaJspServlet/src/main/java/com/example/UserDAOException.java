package com.example;

public class UserDAOException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserDAOException(String message) {
        super(message);
    }

    public UserDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
