 /**
 * 
 */
package com.crs.ibm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.crs.ibm.constant.SQLQueryConstant;
import com.crs.ibm.exception.StudenNotApproved;
import com.crs.ibm.exception.UserNotFound;
import com.crs.ibm.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class StudentDAOImpl implements StudentDAOInterface{
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
		/**
		 * Add Student to CourseRegister Table
		 * @param id
		 * @param ls
		 * @return 1 if user id found in the database or else return 0 
		 */
	   
	public int register(int id, List<String> ls) {
		conn = DBUtils.getConnection();
		int f = 0;
		int mn = 1;
		int mx = 30;
		Random ran = new Random();
		int x = ran.nextInt(mx) + mn;
		   try{


			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_STUDENT_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_STUDENT_ID);
			      while(rs.next()){
			    	  	  int st_id = rs.getInt("id");
				          int adp = rs.getInt("admin_approval");
				          
				          if (st_id == id) {
				        	  if (adp != 0) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.REGISTER_COURSE);
							      String first_course = ls.get(0); 
							      String second_course = ls.get(1);
							      String third_course = ls.get(2);
							      String fourth_course = ls.get(3);
							      stmt.setInt(1, x);
							      stmt.setInt(2, id);
							      stmt.setString(3, first_course);
							      stmt.setString(4, second_course);
							      stmt.setString(5, third_course);
							      stmt.setString(6, fourth_course);
							      stmt.setString(7, null);
							      f = 1;
							      System.out.println("\nCourses Registered");
				        	  }
				          }
			      }
			      stmt.execute();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
		   return f;
	}
	/**
	 * Delete Course from CourseRegister Table
	 * @param id
	 * @param ls
	 *  * @return 1 if user  found in the database or else return 0 
	 */
	
	public int delete_course(int st_id,int crs_id) {
		   
	   	   conn = DBUtils.getConnection();
	   	   int f = 0;
		   try{
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_STUDENT_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_STUDENT_ID);
			      while(rs.next()){
			    	  	  int id = rs.getInt("id");
			    	  	  if (st_id == id) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.DELETE_COURSE_STUDENT);
							      stmt.setInt(1, st_id);
							      f = 1;
			    	  	  }
			      }
		      stmt.execute();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return f;
	}
	/**
	 * Add Course to CourseRegister Table
	 * @param id
	 * @param crs_id
	 * @return 1 if user id found in the database or else return 0 
	 */
	public int add_course(int id,int crs_id) {
		int f = 0;
		conn = DBUtils.getConnection();
		   try{
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_COURSE_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_COURSE_ID);
			      while(rs.next()){
				         int name1 = rs.getInt("course_id");
					   	  if (crs_id == name1) { 
					      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.ADD_COURSE_STUDENT);
					      stmt.setInt(1, crs_id);
					      stmt.setInt(2, id);
					      f = 1;
					      System.out.println("Course added");
					   	  }
			      }
		      stmt.execute();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return f;
	}
	/**
	 * Check if the student id is available or not
	 * @param id
	 * @param crs_id
	 * @return 1 if user id and course id found in the database or else return 0 
	 */
	public int check_st_id(int id,int crs_id) {
		int f = 0;
		conn = DBUtils.getConnection();
		   try{
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_STUDENT_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_STUDENT_ID);
			      while(rs.next()){
				         int name1 = rs.getInt("id");
					   	  if (id == name1) { 
					   		  f = 1;
					   	  }
			      }
		      stmt.execute();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return f;
	}
	
	/**
	 * View Student course from CourseRegister Table
	 * @param id
	 * @return 1 if course id found in the database or else return 0 
	 */
	public int viewCourses(int id) {
	       conn = DBUtils.getConnection();
	       int f = 0;
		   try{

			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.VIEW_COURSES);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.VIEW_COURSES);
				      while(rs.next()){
				    	 int c_id  = rs.getInt("stud_id");
				    	 int r_id = rs.getInt("register_id");
				         String name1 = rs.getString("course1");
				         String name2 = rs.getString("course2");
				         String name3 = rs.getString("course3");
				         String name4 = rs.getString("course4");
				         String name5 = rs.getString("course5");
				         if (c_id == id) {
				         //Display values
				         System.out.println("Registered Courses");
				         System.out.println(name1);
				         System.out.println(name2);
				         System.out.println(name3);
				         System.out.println(name4);
				         if (name5 != null)
				        	 System.out.println(name5+ " (course_id)");
				         f = 1;
				         }
				      }
			        
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return f;
	}
	
	/**
	 * Check Approval of the student
	 * @param name
	 */
	public int check_approval(String user_name) {
		conn = DBUtils.getConnection();
		int f = 0;
		   try{
			   
		   	   conn = DBUtils.getConnection();
			       stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_STUDENT_ID);
				      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_STUDENT_ID);
				      while(rs.next()){
					         String name1 = rs.getString("stud_name");
					          int adp = rs.getInt("admin_approval");
					          if( user_name.equals(name1)) {
					        	  if( adp == 1)
					        		  f = 1;
					          }
			            }
			      stmt.execute();
			      stmt.close();
			      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return f;
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
				 int f = 0;
		   try{
			   
		   	   conn = DBUtils.getConnection();
			       stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_STUDENT_ID);
				      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_STUDENT_ID);
			      while(rs.next()){
				         int name1 = rs.getInt("id");
				         if (name1 == id) {
						      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.PAY_FEE);
						      stmt.setInt(1, x);
						      stmt.setString(2, "Online");
						      stmt.setString(3, pay_type);
						      stmt.setInt(4, amount);
						      stmt.setInt(5, id);
						      f = 1;
						      System.out.println("The amount " + amount + " has been paid for ID no. " + id + " through "+ pay_type + ".");
				         }
			      }
		      stmt.execute();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return f;
	}
	/**
	 * Student viewing their Grade  
	 * @param id
	 * @return 1 if user id found in the database or else return 0 
	 */
	
	public int view_reportCard(int id) {
			int f = 0;
		   try{
			      conn = DBUtils.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.VIEW_REPORT_CARD);			      
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.VIEW_REPORT_CARD);
			      while(rs.next()) {
			    	  int st_id = rs.getInt("id");
			    	  String gd = rs.getString("grade");
			    	  String name = rs.getString("stud_name");
			      
			    	  if(st_id == id) {
			    		  System.out.println("\nTotal Grade of " + name + " is " + gd);
			    		  f = 1;
			    	  }
			      }
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
		   return f;
	}
	
	/**
	 * Update old database and replace it with new one  
	 * @param st_id
	 * @param course_name
	 * @param new_course
	 * @return 1 if user id found in the database or else return 0 
	 */
	
	public int update_already_registered_course(int st_id, String course_name,String new_course) {
	       conn = DBUtils.getConnection();
	       int f = 0;
		   try{

			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.VIEW_COURSES);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.VIEW_COURSES);
				      while(rs.next()){
				    	 int s_id  = rs.getInt("stud_id");
				    	 int r_id = rs.getInt("register_id");
				    	 if (s_id == st_id) { 
					         String name1 = rs.getString("course1");
					         String name2 = rs.getString("course2");
					         String name3 = rs.getString("course3");
					         String name4 = rs.getString("course4");
					         if (name1.equals(course_name)) {
					        	 System.out.println(course_name);
					        	 System.out.println("Old " + name1);
					        	 System.out.println("new " + new_course);
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_ONE_STUDENT);
							      stmt.setString(1, new_course);
							      f = 1;
							      break;
					         }
					         else if (name2.equals(course_name)) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_TWO_STUDENT);
							      stmt.setString(1, new_course);
							      f = 1;
							      break;
					         }
					         else if (name3.equals(course_name)) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_THREE_STUDENT);
							      stmt.setString(1, new_course);
							      f = 1;
							      break;
					         }
					         
					         else if(name4.equals(course_name)) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_FOUR_STUDENT);
							      stmt.setString(1, new_course);
							      f = 1;
							      break;
					         }
				      }
				      }
				      stmt.execute();
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      }// nothing we can do
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try
			   return f;
	}

}
