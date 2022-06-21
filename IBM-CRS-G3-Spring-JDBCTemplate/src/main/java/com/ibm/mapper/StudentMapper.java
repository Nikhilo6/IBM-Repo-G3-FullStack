/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Student;


/**
 * @author 003NZS744
 *
 */
public class StudentMapper implements RowMapper<Student>{
	
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setStud_name(rs.getString("stud_name"));
		student.setAddress(rs.getString("address"));
		student.setEmail(rs.getString("email"));
		student.setGrade(rs.getString("grade"));
		student.setAdmin_approval(rs.getInt("admin_approval"));
		return student;
	}
	
}
