/**
 * 
 */
package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.lti.dao.ProfessorDAOImpl;
import com.lti.dao.ProfessorDAOInterface;
import com.lti.exception.StudentNotFound;
import com.lti.exception.StudentsNotEnrolled;


/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class ProfessorsService implements ProfessorInterface{
	
	ProfessorDAOInterface pr = new ProfessorDAOImpl();
	/**
	 * View Enrolled student from student table
	 * @throws StudentNotEnrolled
	 */
	public void viewEnrolledStudents() throws StudentsNotEnrolled{
		try {
			int v = pr.enrolledStudents();
		if (v == 0) {
			throw new StudentsNotEnrolled();
		}
		}catch(StudentsNotEnrolled s) {
			System.out.println("Students Not Enrolled");
		}
		
	}
	/**
	 * Add Grades to Student in Student Table
	 * @param id
	 * @param name
	 * @param grade
	 * @throws StudentNotFound
	 */
	
	public void addGrades(int id, String name, String grade) throws StudentNotFound{
		
		try {
			int v = pr.add_grade(id, name, grade);
		if (v == 0) {
			throw new StudentNotFound();
		}
		}catch(StudentNotFound s) {
			System.out.println("Student Not Found");
		}
		
	}
	/**
	 * View Course details from Catalog table
	 */
	public void viewCourse() {
		pr.show_course();
		
	}
}
