/**
 * 
 */
package com.ibm.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.ibm.bean.Catalog;
import com.ibm.bean.Student;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.constant.SQLQueryConstant;
import com.ibm.mapper.CatalogMapper;
import com.ibm.mapper.StudentMapper;
/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Repository
public class ProfessorDAOImpl implements ProfessorDAOInterface{
	
		Logger logger = LoggerFactory.getLogger(ProfessorDAOImpl.class);
		
	    @Autowired
	    JDBCConfiguration jdbcConfiguration;
    
	   
		/**
		 * Show course details from catalog
		 */
	   
	   public List<Catalog> show_course() {
			  try {
					String SQL = SQLQueryConstant.SHOW_COURSE_CATALOG;
					
				      List<Catalog> catalog = jdbcConfiguration.jdbcTemplate().query(SQL, new CatalogMapper());
				      return catalog;
		      
			  }catch (EmptyResultDataAccessException e) {
				  return null;
			  }
	}
	   
		/**
		 * Show EnrolledStudents from Student Table in the Database
		 * @return student list if student id found in the database or else return null 
		 */
	   public List<Student> enrolledStudents(){
		   try {
				   String SQL = SQLQueryConstant.SHOW_ENROLLED_STUDENT;
				   List<Student> student = jdbcConfiguration.jdbcTemplate().query(SQL, new StudentMapper());
				   return student;
				      
			  }catch (EmptyResultDataAccessException e) {
				  return null;
			  }
	   }
	   
		/**
		 * Add Grades to Students in Student Table
		 * @param id
		 * @param name 
		 * @param grade
		 * @return 1 if user id found in the database or else return 0 
		 */
	   public int add_grade(int id, String grade) {
		   try {
					  String SQL = SQLQueryConstant.ADD_GRADES;
					  jdbcConfiguration.jdbcTemplate().update(SQL, id, grade);
				      return 1;
		      
			  }catch (EmptyResultDataAccessException e) {
				  return 0;
			  }
	   }

}
