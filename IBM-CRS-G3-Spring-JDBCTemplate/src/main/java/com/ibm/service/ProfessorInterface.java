/**
 * 
 */
package com.ibm.service;

import java.util.List;


import org.springframework.stereotype.Component;

import com.ibm.bean.Catalog;
import com.ibm.bean.Student;
import com.ibm.exception.StudentNotFound;
import com.ibm.exception.StudentsNotEnrolled;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Component
public interface ProfessorInterface {
		
	
	public List<Student> viewEnrolledStudents() throws StudentsNotEnrolled;
	public boolean addGrades(int id, String grade) throws StudentNotFound;
	public List<Catalog> viewCourse();

}
