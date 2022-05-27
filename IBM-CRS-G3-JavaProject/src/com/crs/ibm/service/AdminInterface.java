/**
 * 
 */
package com.crs.ibm.service;

import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.ProfessorNotFound;
import com.crs.ibm.exception.StudentNotFound;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface AdminInterface {
	
	public void addCourse(String n, int id) throws CourseNotFound;
	public void removeCourse(int id) throws CourseNotFound;
	public void assignCourseProfessor(int p_id ,int c_id ) throws ProfessorNotFound;
	public void set_admin_approval(int name) throws StudentNotFound;
	public void addProfessor(int n, String name) throws ProfessorNotFound;

}
