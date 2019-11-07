package com.marsrovers.rover.exception;

/**
 * Thrown when the user requests the execution of a not valid command 
 * @author fab
 *
 */
public class CommandNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public CommandNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
