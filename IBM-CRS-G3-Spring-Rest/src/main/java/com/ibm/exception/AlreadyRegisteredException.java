/**
 * 
 */
package com.ibm.exception;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class AlreadyRegisteredException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AlreadyRegisteredException() {
		super("Already registered \nTry again.");
	}
	public AlreadyRegisteredException(String message) {
		super(message);
	}
	
}
