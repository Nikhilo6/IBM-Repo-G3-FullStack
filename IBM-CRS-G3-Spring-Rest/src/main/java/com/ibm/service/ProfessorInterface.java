/**
 * 
 */
package com.ibm.service;

import java.util.List;


import org.springframework.stereotype.Component;
import com.ibm.exception.StudentNotFound;
import com.ibm.exception.StudentsNotEnrolled;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Component
public interface ProfessorInterface {
		
	
	public List<String> viewEnrolledStudents() throws StudentsNotEnrolled;
	public boolean addGrades(int id, String grade) throws StudentNotFound;
	public List<String> viewCourse();

}
