/**
 * 
 */
package com.ibm.exception;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class StudentNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public StudentNotFound() {
		super("Student not found \nTry again.");
	}
	public StudentNotFound(String message) {
		super(message);
	}

}