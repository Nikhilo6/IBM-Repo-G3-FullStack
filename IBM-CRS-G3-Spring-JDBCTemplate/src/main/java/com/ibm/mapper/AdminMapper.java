/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Admin;

/**
 * @author 003NZS744
 *
 */
public class AdminMapper implements RowMapper<Admin> {
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Admin admin = new Admin();
		admin.setAdmin_id(rs.getInt("admin_id"));
		admin.setName(rs.getString("name"));
		admin.setStud_id(rs.getInt("stud_id"));
		return admin;
	}
}
