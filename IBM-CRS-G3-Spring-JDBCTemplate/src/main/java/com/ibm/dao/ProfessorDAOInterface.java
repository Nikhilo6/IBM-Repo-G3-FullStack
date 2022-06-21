/**
 * 
 */
package com.ibm.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.ibm.bean.Catalog;
import com.ibm.bean.Student;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Repository
public interface ProfessorDAOInterface {
	
	public List<Catalog> show_course();
	public List<Student> enrolledStudents();
	public int add_grade(int id, String grade);
}
