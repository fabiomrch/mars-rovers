package com.marsrovers.rover.exception;

/**
 * Exception that identifies a state in which robot cannot perform the requested movement
 * @author fab
 *
 */
public class CommandNotAllowedException extends Exception {
	private static final long serialVersionUID = 1L;

	public CommandNotAllowedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
