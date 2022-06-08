/**
 * 
 */
package com.lti.exception;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class CourseNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CourseNotFound() {
		super("Course not found \nTry again.");
	}
	public CourseNotFound(String message) {
		super(message);
	}
	
}
