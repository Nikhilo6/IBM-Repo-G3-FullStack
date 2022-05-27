/**
 * 
 */
package com.crs.ibm.service;

import com.crs.ibm.exception.NewUserProperName;
import com.crs.ibm.exception.UserNotFound;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface UserInterface {
	
	public void login(String n7, String n8) throws UserNotFound;
	public void password_change(int id, String pw) throws UserNotFound;
	public void new_user(String id, String name, String pw) throws NewUserProperName ; 
	public void add_stud(String name, String email);
	public void add_prof(String name, String email);
	public void add_admin(String name, String email);
}
