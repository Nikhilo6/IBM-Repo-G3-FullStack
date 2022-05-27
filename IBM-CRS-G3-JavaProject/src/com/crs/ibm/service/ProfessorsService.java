/**
 * 
 */
package com.crs.ibm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.crs.ibm.application.CRSApplication;
import com.crs.ibm.dao.ProfessorDAOImpl;
import com.crs.ibm.dao.ProfessorDAOInterface;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.StudentNotFound;
import com.crs.ibm.exception.StudentsNotEnrolled;

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
			CRSApplication.main(null);
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
			CRSApplication.main(null);
		}
		
	}
	/**
	 * View Course details from Catalog table
	 */
	public void viewCourse() {
		pr.show_course();
		
	}
}
