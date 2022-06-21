/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ibm.bean.Catalog;


/**
 * @author 003NZS744
 *
 */
public class CatalogMapper implements RowMapper<Catalog>{
	public Catalog mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		   Catalog cr = new Catalog();
		   cr.setCatalog_id(rs.getInt("catalog_id"));
		   cr.setCourse_id(rs.getInt("course_id"));
		   cr.setCourse_name(rs.getString("course_name"));
		   cr.setCourse_type(rs.getString("course_type"));
		   cr.setSemseter(rs.getInt("semester"));
	       return cr;
}
}
