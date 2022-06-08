/**
 * 
 */
package com.ibm.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Repository
public interface ProfessorDAOInterface {
	
	public List<String> show_course();
	public List<String> enrolledStudents();
	public int add_grade(int id, String grade);
}
