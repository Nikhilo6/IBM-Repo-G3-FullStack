 /**
 * 
 */
package com.ibm.dao;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;
import com.ibm.constant.SQLQueryConstant;
import com.ibm.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Repository
public class StudentDAOImpl implements StudentDAOInterface{
	   Connection conn = null;
	   PreparedStatement stmt = null;
	     
		/**
		 * Add Student to CourseRegister Table
		 * @param id
		 * @param ls
		 * @return 1 if user id found in the database or else return 0 
		 */
	   
	   public List<String> register(int id, String c1, String c2, String c3, String c4) {
		conn = DBUtils.getConnection();
		List<String> lst = new ArrayList<String>();
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
							      
							      lst.add(c1);
							      lst.add(c2);
							      lst.add(c3);
							      lst.add(c4);
							      
							      stmt.setInt(1, x);
							      stmt.setInt(2, id);
							      stmt.setString(3, c1);
							      stmt.setString(4, c2);
							      stmt.setString(5, c3);
							      stmt.setString(6, c4);
							      stmt.setString(7, null);
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
		   return lst;
	}
	/**
	 * Delete Course from CourseRegister Table
	 * @param id
	 * @param ls
	 *  * @return 1 if user  found in the database or else return 0 
	 */
	
	
	public int delete_course(int st_id,String crs_id) {
		   
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
	public int add_course(int id, String crs_name) {
		int f = 0;
		conn = DBUtils.getConnection();
		   try{
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_COURSE);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_COURSE);
			      while(rs.next()){
			    	  ;
				         String name1 = rs.getString("course_name");
					   	  if (crs_name.equals(name1)) { 
					      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.ADD_COURSE_STUDENT);
					      stmt.setString(1, crs_name);
					      stmt.setInt(2, id);
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
	public List<String> viewCourses(int stud_id_from_user) {
	       conn = DBUtils.getConnection();
	       List<String> ls = new ArrayList<String>();
		   try{

			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.VIEW_COURSES);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.VIEW_COURSES);
				      while(rs.next()){
				    	 int stud_id_from_table  = rs.getInt("stud_id");
				         String name1 = rs.getString("course1");
				         String name2 = rs.getString("course2");
				         String name3 = rs.getString("course3");
				         String name4 = rs.getString("course4");
				         String name5 = rs.getString("course5");
				         if (stud_id_from_table == stud_id_from_user) {
				        	 ls.add(name1);
				        	 ls.add(name2);
				        	 ls.add(name3);
				        	 ls.add(name4);
				        	 ls.add(name5);
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
		   return ls;
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
	
	public String view_reportCard(int id) {
			String s = "";
		   try{
			      conn = DBUtils.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.VIEW_REPORT_CARD);			      
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.VIEW_REPORT_CARD);
			      while(rs.next()) {
			    	  int st_id = rs.getInt("id");
			    	  String gd = rs.getString("grade");
			      
			    	  if(st_id == id) {
			    		  
			    		  s += gd;
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
		   return s;
	}
	
	/**
	 * Update old database and replace it with new one  
	 * @param st_id
	 * @param course_name
	 * @param new_course
	 * @return 1 if user id found in the database or else return 0 
	 */
	
	public List<String> update_already_registered_course(int st_id, String course_name,String new_course) {
	       conn = DBUtils.getConnection();
	       List<String> lst = new ArrayList<String>();
		   try{

			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.VIEW_COURSES);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.VIEW_COURSES);
				      while(rs.next()){
				    	 int s_id  = rs.getInt("stud_id");
				    	 if (s_id == st_id) { 
					         String name1 = rs.getString("course1");
					         String name2 = rs.getString("course2");
					         String name3 = rs.getString("course3");
					         String name4 = rs.getString("course4");
					         if (name1.equals(course_name)) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_ONE_STUDENT);
							      stmt.setString(1, new_course);
							      lst.add(new_course);
							      lst.add(name2);
							      lst.add(name3);
							      lst.add(name4);
					         }
					         else if (name2.equals(course_name)) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_TWO_STUDENT);
							      stmt.setString(1, new_course);
							      lst.add(name1);
							      lst.add(new_course);
							      lst.add(name3);
							      lst.add(name4);
					         }
					         else if (name3.equals(course_name)) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_THREE_STUDENT);
							      stmt.setString(1, new_course);
							      lst.add(name1);
							      lst.add(name2);
							      lst.add(new_course);
							      lst.add(name4);
					         }
					         
					         else if(name4.equals(course_name)) {
							      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.UPDATE_COURSE_FOUR_STUDENT);
							      stmt.setString(1, new_course);
							      lst.add(name1);
							      lst.add(name2);
							      lst.add(name3);
							      lst.add(new_course);
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
			   return lst;
	}
	}


