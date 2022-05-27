/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class ProfessorNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProfessorNotFound() {
		super("Professor Not Found\nTry again.");
	}
	public ProfessorNotFound(String message) {
		super(message);
	}

}
