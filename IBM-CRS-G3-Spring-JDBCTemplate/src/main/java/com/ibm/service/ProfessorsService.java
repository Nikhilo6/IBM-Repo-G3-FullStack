/**
 * 
 */
package com.ibm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bean.Catalog;
import com.ibm.bean.Student;
import com.ibm.dao.ProfessorDAOInterface;
import com.ibm.exception.StudentNotFound;
import com.ibm.exception.StudentsNotEnrolled;


/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Service
public class ProfessorsService implements ProfessorInterface{
	
	@Autowired
	ProfessorDAOInterface pr;
	/**
	 * View Enrolled student from student table
	 * @throws StudentNotEnrolled
	 */
	public List<Student> viewEnrolledStudents() throws StudentsNotEnrolled{
		try {
			List<Student> v = pr.enrolledStudents();
		if (v.isEmpty() || v == null) {
			throw new StudentsNotEnrolled();
		}
		else
			return v;
		}catch(StudentsNotEnrolled s) {
		}
		return null;
	}
	/**
	 * Add Grades to Student in Student Table
	 * @param id
	 * @param name
	 * @param grade
	 * @throws StudentNotFound
	 */
	
	public boolean addGrades(int id, String grade) throws StudentNotFound{
		
		try {
			int v = pr.add_grade(id, grade);
		if (v == 0) {
			throw new StudentNotFound();
		}
		else
			return true; 
		}catch(StudentNotFound s) {
		}
		return false;
		
	}
	/**
	 * View Course details from Catalog table
	 */
	public List<Catalog> viewCourse() {
		if (pr.show_course().isEmpty() || pr.show_course() == null)
			return null;
		return pr.show_course();
		
	}
}
