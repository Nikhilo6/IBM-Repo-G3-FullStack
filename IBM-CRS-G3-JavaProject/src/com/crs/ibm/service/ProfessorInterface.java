/**
 * 
 */
package com.crs.ibm.service;

import com.crs.ibm.exception.StudentNotFound;
import com.crs.ibm.exception.StudentsNotEnrolled;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface ProfessorInterface {
		
	
	public void viewEnrolledStudents() throws StudentsNotEnrolled;
	public void addGrades(int id, String name, String grade) throws StudentNotFound;
	public void viewCourse();

}
