/**
 * 
 */
package com.lti.exception;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class UserNotFound extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFound() {
		super("User not found \n Try again.");
	}
	public UserNotFound(String message) {
		super(message);
	}
}
