/**
 * 
 */
package com.lti.dao;


/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface AdminDAOInterface {
	
	public void addCourse(String course, int id);
	public int deleteCourse(int id);
	public int addProfessor(int prof_id,String prof_name);
	public int assign_crs_to_Professor(int p_id ,int c_id );
	public int set_stud_approval(int  name);
	public void assign(int p_id ,int c_id );
	public void addCourse_to_catalog(String course, int id);
	public void deleteCourse_from_catalog(int id);
}
