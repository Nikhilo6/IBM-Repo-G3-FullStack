/**
 * 
 */
package com.lti.exception;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class StudentsNotEnrolled  extends Exception {
	private static final long serialVersionUID = 1L;
	
	public StudentsNotEnrolled() {
		super("Student not Enrolled \nTry again.");
	}
	public StudentsNotEnrolled(String message) {
		super(message);
	}
}
