/**
 * 
 */
package com.crs.ibm.dao;

import com.crs.ibm.exception.UserNotFound;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface UserDAOInterface {
	
	public int getUsernamePassword(String name,String password);
	
	public void newUser(String id, String name, String pw);
	public int pw_change(int id, String pw);
	public void add_student(String name, String email);
	public void add_prof(String name, String email);
	public void add_student_role_table(String e);
	public void add_prof_role_table(String e);
	public void add_admin(String name, String email);
	public void add_admin_role_table(String e);
}
