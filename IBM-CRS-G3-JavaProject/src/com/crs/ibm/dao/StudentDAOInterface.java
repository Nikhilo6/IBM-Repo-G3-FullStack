/**
 * 
 */
package com.crs.ibm.dao;

import java.util.List;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface StudentDAOInterface {


	public int register(int id, List<String> ls);
	public int delete_course(int st_id,int crs_id);
	public int add_course(int stud_id, int course_id);
	public int check_st_id(int id,int crs_id);
	public int viewCourses(int id);
	public int pay_fee(int id, int amount,  String pay_type); 
	public int view_reportCard(int id);
	public int check_approval(String u_name);
	public int update_already_registered_course(int st_id, String course_name, String new_course);
}
