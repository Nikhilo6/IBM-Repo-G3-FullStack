/**
 * 
 */
package com.crs.ibm.service;

import java.io.*;

import com.crs.ibm.application.CRSApplication;
import com.crs.ibm.dao.UserDAOImpl;
import com.crs.ibm.dao.UserDAOInterface;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.NewUserProperName;
import com.crs.ibm.exception.UserNotFound;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class UserService implements UserInterface{
	
	UserDAOInterface us = new UserDAOImpl();
	/**
	 * Login to main Page
	 * @param username
	 * @param password
	 * @throws UserNotFound
	 */
	
	public void login(String username, String password) throws UserNotFound  {
		
			// call method from UserDaoInterface
		try {
			int v = us.getUsernamePassword(username, password);
			if (v == 0) {
				throw new UserNotFound("User not Found");
			}
		}catch(UserNotFound e) {
			System.out.println(e.getMessage());
			CRSApplication.main(null);
		}
	}
	/**
	 * Change password of Users
	 * @param id
	 * @param pw
	 * @throws UserNotFound
	 */
	
	public void password_change(int id, String pw)  throws UserNotFound{
		
//		call method from UserDaoInterface
		
		try {
			int v = us.pw_change(id, pw);
			if (v == 0) {
				throw new UserNotFound("User not Found");
			}
		}catch(UserNotFound e) {
			System.out.println(e.getMessage());
			CRSApplication.main(null);
		}

	}
	
	/**
	 * Adding new user to database
	 * @param id
	 * @param name
	 * @param pw
	 * @throws NewUserProperName
	 */
	
	public void new_user(String id, String name, String pw) throws NewUserProperName{
		try {
			    us.newUser(id, name, pw);
			    if (name == null || pw == null) {
					throw new NewUserProperName();
			    }
		}catch(NewUserProperName e) {
			System.out.println(e.getMessage());
			CRSApplication.main(null);
		}
		
	}
	/**
	 * Adding new student to database
	 * @param name
	 * @param email
	 */
	public void add_stud(String name, String email){
		us.add_student(name, email);
		us.add_student_role_table(email);
		System.out.println("New user account has been created \n");
		CRSApplication.main(null);
		
	}
	/**
	 * Adding new professor to database
	 * @param name
	 * @param email
	 */
	public void add_prof(String name, String email){
		us.add_prof(name, email);
		us.add_prof_role_table(email);
		System.out.println("New user account has been created \nYou can login now.");
		CRSApplication.main(null);	
	}
	/**
	 * Adding new admin to database
	 * @param name
	 * @param email
	 */
	public void add_admin(String name, String email){
		us.add_admin(name, email);
		us.add_admin_role_table(email);
		System.out.println("New user account has been created \n");
		CRSApplication.main(null);
		
	}
}
