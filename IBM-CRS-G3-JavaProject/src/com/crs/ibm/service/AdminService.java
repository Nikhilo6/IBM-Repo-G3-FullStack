/**
 * 
 */
package com.crs.ibm.service;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.crs.ibm.application.CRSApplication;
import com.crs.ibm.bean.*;
import com.crs.ibm.dao.AdminDAOImpl;
import com.crs.ibm.dao.AdminDAOInterface;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.ProfessorNotFound;
import com.crs.ibm.exception.StudentNotFound;
import com.crs.ibm.exception.UserNotFound;
/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class AdminService implements AdminInterface {
	
	AdminDAOInterface ad = new AdminDAOImpl();
	
	
	/**
	 * Add Course to Course Table
	 * @param course
	 * @param id
	 * @throws CourseNotFound
	 */
	
	public void addCourse(String course, int id) throws CourseNotFound{
		try {
			ad.addCourse(course, id);
			ad.addCourse_to_catalog(course, id);
			CRSApplication.main(null);
		if (course == null && id == 0) {
			throw new CourseNotFound();
		}
		}catch(CourseNotFound c) {
		System.out.println(c.getMessage());
		CRSApplication.main(null);
	}
	}
	
	
	/**
	 * Delete Course to Course Table
	 * @param id
	 * @throws CourseNotFound
	 */
	
	public void removeCourse(int id) throws CourseNotFound {
		try {
			int v = ad.deleteCourse(id);
			ad.deleteCourse_from_catalog(id);
			CRSApplication.main(null);
		if (id == 0 || v == 0) {
			throw new CourseNotFound();
		   }
		}catch(CourseNotFound c) {
		System.out.println(c.getMessage());
		CRSApplication.main(null);
		}
	}
	/**
	 * Assign Course to Professors 
	 * @param p_id
	 * @param c_id
	 * @throws ProfessorNotFound
	 */
	
	public void assignCourseProfessor(int p_id ,int c_id ) throws ProfessorNotFound {
		try {
		int v = ad.assign_crs_to_Professor(p_id, c_id);
		if (v == 1) {
			ad.assign(p_id, c_id);
			System.out.println("Professor ID " + p_id + " has been assigned to " + c_id);
			CRSApplication.main(null);
		}
		if( v== 0) {
			throw new ProfessorNotFound();
		}
		}catch(ProfessorNotFound e) {
			System.out.println(e.getMessage());
			CRSApplication.main(null);
}
	}
	/**
	 * Approve Student by Admin 
	 * @param id
	 * @throws StudentNotFound
	 */
	
	public void set_admin_approval(int id) throws StudentNotFound {
		try {
		int v = ad.set_stud_approval(id);
		if (id == 0 || v == 0) {
			throw new StudentNotFound("Student not Found");
		}
	}catch(StudentNotFound e) {
		System.out.println(e.getMessage());
		CRSApplication.main(null);
	}
		
		/**
		 * Add Professor by admin into professor table 
		 * @param prof_id
		 * @param prof_name
		 * @throws StudentNotFound
		 */
	}
	public void addProfessor(int prof_id,String prof_name) throws ProfessorNotFound{
		try {
		     int v = ad.addProfessor(prof_id, prof_name);
		if (prof_id == 0 || v == 0) {
			throw new ProfessorNotFound("Professor Not Found");
		}
	}catch(ProfessorNotFound e) {
		System.out.println(e.getMessage());
		CRSApplication.main(null);
	}

	}
	
}
	
