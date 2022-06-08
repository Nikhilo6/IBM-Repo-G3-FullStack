/**
 * 
 */
package com.lti.dao;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface ProfessorDAOInterface {
	
	public void show_course();
	public int enrolledStudents();
	public int add_grade(int id, String name, String grade);
}
