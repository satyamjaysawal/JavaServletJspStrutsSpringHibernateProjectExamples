package com.example.DAO;

public class EmployeeDAOException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeDAOException(String message) {
        super(message);
    }

    public EmployeeDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
