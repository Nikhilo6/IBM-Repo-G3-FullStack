/**
 * 
 */
package com.ibm.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ibm.bean.Professor;

/**
 * @author 003NZS744
 *
 */
public class ProfessorMapper implements RowMapper<Professor>{
		
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Professor prof = new Professor();
		prof.setProf_name(rs.getString("prof_name"));
		prof.setAddress(rs.getString("address"));
		prof.setEmail(rs.getString("email"));
		prof.setProf_id(rs.getInt("prof_id"));
		prof.setCourseID(rs.getInt("courseID"));

		return prof;
	}
	
}
