/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class StudenNotApproved extends Exception{
	
	private static final long serialVersionUID = 1L;

	public StudenNotApproved() {
		super("Student has not been approved.\n");
	}
	public StudenNotApproved(String message) {
		super(message);
}
}
