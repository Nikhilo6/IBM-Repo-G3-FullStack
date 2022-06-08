/**
 * 
 */
package com.lti.service;

import com.lti.exception.StudentNotFound;
import com.lti.exception.StudentsNotEnrolled;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface ProfessorInterface {
		
	
	public void viewEnrolledStudents() throws StudentsNotEnrolled;
	public void addGrades(int id, String name, String grade) throws StudentNotFound;
	public void viewCourse();

}
