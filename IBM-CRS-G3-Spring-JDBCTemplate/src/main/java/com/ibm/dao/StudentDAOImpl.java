 /**
 * 
 */
package com.ibm.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import com.ibm.bean.CourseRegister;
import com.ibm.bean.Student;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.constant.SQLQueryConstant;
import com.ibm.mapper.CourseRegisterMapper;
import com.ibm.mapper.StudentMapper;


/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Repository
public class StudentDAOImpl implements StudentDAOInterface{
		
	
	Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	
    @Autowired
    JDBCConfiguration jdbcConfiguration;
    
		/**
		 * Add Student to CourseRegister Table
		 * @param id
		 * @param ls
		 * @return list if id is found else return null
		 */

    
	   public List<String> register(int id, String course1, String course2, String course3, String course4) {
				List<String> lst = new ArrayList<String>();
				int mn = 1;
				int mx = 30;
				Random ran = new Random();
				int x = ran.nextInt(mx) + mn;
				
				try  {
					String SQL = SQLQueryConstant.REGISTER_COURSE;
					jdbcConfiguration.jdbcTemplate().update(SQL,x, id, course1, course2, course3, course4, null);
					lst.add("Student ID " + id + "Course1: " + course1+ "Course2 " + course2 + "Course3 " + course3+ "Course4 "  + course4);
					return lst;
					
			      
				  }catch (EmptyResultDataAccessException e) {
					  return null;
				  }	
	      }
	/**
	 * Delete Course from CourseRegister Table
	 * @param id
	 * @param ls
	 *  * @return 1 if user  found in the database or else return 0 
	 */
	
	
	public int delete_course(int st_id,String crs_id) {
		   try {
				 String SQL = SQLQueryConstant.DELETE_COURSE_STUDENT;
				 jdbcConfiguration.jdbcTemplate().update(SQL, st_id);
			      return 1;
			      
			  }catch (EmptyResultDataAccessException e) {
				  return 0;
			  }
	}
	/**
	 * Add Course to CourseRegister Table
	 * @param id
	 * @param crs_id
	 * @return 1 if user id found in the database or else return 0 
	 */
	public int add_course(int id, String crs_name) {
		
		try {
				 String SQL = SQLQueryConstant.ADD_COURSE_STUDENT;
				 jdbcConfiguration.jdbcTemplate().update(SQL, crs_name, id);
			      return 1;
	      
		  }catch (EmptyResultDataAccessException e) {
			  return 0;
		  }
	}

	/**
	 * View Student course from CourseRegister Table
	 * @param id
	 * @return 1 if course id found in the database or else return 0 
	 */
	public List<String> viewCourses(int id) {
		  List<String> ls = new ArrayList<String>();
		  
		  try {
			  String SQL = SQLQueryConstant.VIEW_COURSES;
			  @SuppressWarnings("deprecation")
			CourseRegister courses =jdbcConfiguration.jdbcTemplate().queryForObject(SQL,new Object[]{id}, new CourseRegisterMapper());
		      String c1 = courses.getCourse1();
		      String c2 = courses.getCourse2();
		      String c3 = courses.getCourse3();
		      String c4 = courses.getCourse4();
		      String c5 = courses.getCourse5();
		      ls.add(" Course1 :" + c1 + " Course2 :" + c2 + " Course3 :" + c3 + " Course4 :" + c4 + " Course5 :" + c5);
		      return ls;
		      
	      
		  }catch (EmptyResultDataAccessException e) {
			  return null;
		  }
	}
	
	/**
	 * Check Approval of the student
	 * @param name
	 */
	public int check_approval(String user_name) {
		String SQL = SQLQueryConstant.VIEW_REPORT_CARD;
		@SuppressWarnings("deprecation")
		Student student =jdbcConfiguration.jdbcTemplate().queryForObject(SQL,new Object[]{user_name}, new StudentMapper());
		if (student.getAdmin_approval() == 1)
		   return 1;
		return 0;
	}
	/**
	 * Student paying fee
	 * @param id
	 * @param amount
	 * @return 1 if user id found in the database or else return 0 
	 */
	
	public int pay_fee(int id, int amount,  String pay_type) {
				int mn = 1000;
				int mx = 2000;
				Random ran = new Random();
				int x = ran.nextInt(mx) + mn;
				try {
					 String SQL = SQLQueryConstant.PAY_FEE;
					 jdbcConfiguration.jdbcTemplate().update(SQL, x, "Online", pay_type, amount, id);
				      return 1;
				      
			      
				  }catch (EmptyResultDataAccessException e) {
					  return 0;
				  }
	}
	/**
	 * Student viewing their Grade  
	 * @param id
	 * @return grade if user id found in the database or else return null 
	 */
	
	public String view_reportCard(int id) {
			String s = "";
			
			try {
					String SQL = SQLQueryConstant.VIEW_REPORT_CARD;
					@SuppressWarnings("deprecation")
					Student student =jdbcConfiguration.jdbcTemplate().queryForObject(SQL,new Object[]{id}, new StudentMapper());
					s += student.getGrade();
				   return s;
		      
			  }catch (EmptyResultDataAccessException e) {
				  return null;
			  }
	}
	
	/**
	 * Update old database and replace it with new one  
	 * @param st_id
	 * @param course_name
	 * @param new_course
	 * @return 1 if user id found in the database or else return 0 
	 */
	
	public List<String> update_already_registered_course(int st_id, String course_name,String new_course) {
	       List<String> lst = new ArrayList<String>();
	       
	       try {
	              String SQL = SQLQueryConstant.VIEW_COURSES;
	              
			      @SuppressWarnings("deprecation")
				CourseRegister courses =jdbcConfiguration.jdbcTemplate().queryForObject(SQL,new Object[]{st_id}, new CourseRegisterMapper());
			        
					         String name1 = courses.getCourse1();
					         String name2 = courses.getCourse2();
					         String name3 = courses.getCourse3();
					         String name4 = courses.getCourse4();
					         int ID = courses.getStud_id();
					      if (ID == st_id) {
					         if (name1.equals(course_name)) {
					        	 
								 String SQL1 = SQLQueryConstant.UPDATE_COURSE_ONE_STUDENT;
								 jdbcConfiguration.jdbcTemplate().update(SQL1, new_course);
							      lst.add(new_course);
							      lst.add(name2);
							      lst.add(name3);
							      lst.add(name4);
					         }
					         else if (name2.equals(course_name)) {
								 String SQL2 = SQLQueryConstant.UPDATE_COURSE_TWO_STUDENT;
								 jdbcConfiguration.jdbcTemplate().update(SQL2, new_course);
							      lst.add(name1);
							      lst.add(new_course);
							      lst.add(name3);
							      lst.add(name4);
					         }
					         else if (name3.equals(course_name)) {
								 String SQL3 = SQLQueryConstant.UPDATE_COURSE_THREE_STUDENT;
								 jdbcConfiguration.jdbcTemplate().update(SQL3, new_course);
							      lst.add(name1);
							      lst.add(name2);
							      lst.add(new_course);
							      lst.add(name4);
					         }
					         
					         else if(name4.equals(course_name)) {
								 String SQL4 = SQLQueryConstant.UPDATE_COURSE_FOUR_STUDENT;
								 jdbcConfiguration.jdbcTemplate().update(SQL4, new_course);
							      lst.add(name1);
							      lst.add(name2);
							      lst.add(name3);
							      lst.add(new_course);
				      }
					      }
			   return lst;
			      
			  }catch (EmptyResultDataAccessException e) {
				  return null;
			  }
	}

	}


