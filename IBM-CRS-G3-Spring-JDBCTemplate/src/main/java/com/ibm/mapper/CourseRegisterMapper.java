/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.CourseRegister;

/**
 * @author 003NZS744
 *
 */
public class CourseRegisterMapper implements RowMapper<CourseRegister>{
	
	public CourseRegister mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		  CourseRegister cr = new CourseRegister();
		  cr.setStud_id(rs.getInt("stud_id"));
		  cr.setCourse1(rs.getString("course1"));
		  cr.setCourse2(rs.getString("course2"));
		  cr.setCourse3(rs.getString("course3"));
		  cr.setCourse4(rs.getString("course4"));
		  cr.setCourse5(rs.getString("course5"));
	      return cr;
}
	
}
