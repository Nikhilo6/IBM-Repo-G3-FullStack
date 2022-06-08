/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.constant.SQLQueryConstant;
import com.lti.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;
import java.util.*;
/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class ProfessorDAOImpl implements ProfessorDAOInterface{
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
		/**
		 * Show course details from catalog
		 */
	   
	   public void show_course() {
		   List<String> ls = new ArrayList<String>();
		   try{
			      conn = DBUtils.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.SHOW_COURSE_CATALOG);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.SHOW_COURSE_CATALOG);
			      
			      while(rs.next()){
			         int ca_id  = rs.getInt("catalog_id");
			         int cs_id  = rs.getInt("course_id");
			         String name = rs.getString("course_name");
			         String tp = rs.getString("course_type");
			         int sem = rs.getInt("semester");		         
			         System.out.println("Catalog_ID --> " + ca_id + " , Course_ID--> " + cs_id + "  , Cousre_Name--> " + name + "  Course_Type-->  " + tp + " , Semester-->  " + sem);
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
	}
	   
		/**
		 * Show EnrolledStudents from Student Table in the Database
		 * @return 1 if student id found in the database or else return 0 
		 */
	   public int enrolledStudents(){
		   List<String> ls = new ArrayList<String>();
		  int f = 0;
		   try{
			      conn = DBUtils.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.SHOW_ENROLLED_STUDENT);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.SHOW_ENROLLED_STUDENT);
			      while(rs.next()){
			    	 int s_id = rs.getInt("id");
			         String name = rs.getString("stud_name");
			         String email = rs.getString("email");
			         if (s_id == 0) {
			        	 break;
			         }
			         ls.add(name);
//			         System.out.println("Name--> " + name + "  , ID--> " + s_id + "  , Email--> " + email);
			         f = 1;
			      }
			      
			      ls.forEach(System.out::println);
			      
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
		   return f ;
	   }
	   
		/**
		 * Add Grades to Students in Student Table
		 * @param id
		 * @param name 
		 * @param grade
		 * @return 1 if user id found in the database or else return 0 
		 */
	   public int add_grade(int id, String name, String grade) {
		   conn = DBUtils.getConnection();
		   int f = 0;
		   try{
			   
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueryConstant.GET_STUDENT_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueryConstant.GET_STUDENT_ID);
			      while(rs.next()){
				         int id1 = rs.getInt("id");
				         if (id == id1) {
					      stmt = (PreparedStatement) conn.prepareStatement(SQLQueryConstant.ADD_GRADES);
					      stmt.setString(1, grade);
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

}
