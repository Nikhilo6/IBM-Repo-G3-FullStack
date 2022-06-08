/**
 * 
 */
package com.ibm.dao;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.ibm.constant.SQLQueryConstant;
import com.ibm.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;
/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Repository
public class ProfessorDAOImpl implements ProfessorDAOInterface{
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
		/**
		 * Show course details from catalog
		 */
	   
	   public List<String> show_course() {
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
			         
			         ls.add("Course : " + name + " CourseID : " + cs_id + " Course Type : " + tp +
			        		 " CatalogID : " + ca_id + " Semseter : " + sem);
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
		 * Show EnrolledStudents from Student Table in the Database
		 * @return 1 if student id found in the database or else return 0 
		 */
	   public List<String> enrolledStudents(){
		   List<String> st = new ArrayList<String>();
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
			         st.add("Name :" + name + " StudentID : " + s_id + " Email : " + email);
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
		   return st;
	   }
	   
		/**
		 * Add Grades to Students in Student Table
		 * @param id
		 * @param name 
		 * @param grade
		 * @return 1 if user id found in the database or else return 0 
		 */
	   public int add_grade(int id, String grade) {
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
