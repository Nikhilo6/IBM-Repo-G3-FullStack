/**
 * 
 */
package com.crs.ibm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crs.ibm.application.CRSApplication;
import com.crs.ibm.dao.StudentDAOImpl;
import com.crs.ibm.dao.StudentDAOInterface;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.StudenNotApproved;
import com.crs.ibm.exception.StudentNotFound;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class StudentService implements StudentInterface{

	StudentDAOInterface st = new StudentDAOImpl();
	
	/**
	 * Add Course to CourseRegister Table
	 * @param stud_id
	 * @param course_id
	 * @throws CourseNotFound, StudentNotApproved
	 */
	
	public void addCourse(int stud_id, int course_id) throws CourseNotFound, StudenNotApproved {
		try {
			int c = st.check_st_id(stud_id, course_id);
			
			if (c == 0) {
				throw new StudenNotApproved();
			}
			int v = st.add_course(stud_id, course_id);
		if (v == 0) {
			throw new CourseNotFound();
		}
		}
		catch(StudenNotApproved s1) {
			System.out.println("Student Not Found");
			CRSApplication.main(null);
		}catch(CourseNotFound s) {
			System.out.println("Course Not Added");
			CRSApplication.main(null);
		}
	
	}
	/**
	 * Add Student to CourseRegister Table
	 * @param stud_id
	 * @param ls
	 * @throws StudentNotApproved
	 */
	public void registerCourse(int id, List<String> ls) throws StudenNotApproved{
		try {
		int v = st.register(id, ls);
		if (v == 0) {
			throw new StudenNotApproved();
		}
		}catch(StudenNotApproved s) {
			System.out.println("Student has not been approved");
			CRSApplication.main(null);
		}
	}
	/**
	 * Delete Course from CourseRegister Table
	 * @param st_id
	 * @param cr_id
	 * @throws StudentNotApproved
	 */

	public void dropCourse(int st_id,int cr_id) throws StudentNotFound{
		
		try {
			int v = st.delete_course(st_id, cr_id);
		if (v == 0) {
			throw new StudentNotFound();
		}
		}catch(StudentNotFound s) {
			System.out.println("Student Not Found");
			CRSApplication.main(null);
		}
		
	}
	
	/**
	 * View Grade of a student
	 * @param id
	 * @throws StudentNotFound
	 */
	public void viewReportCard(int id) throws StudentNotFound {
		try {
			int v = st.view_reportCard(id);
		if (v == 0) {
			throw new StudentNotFound();
		}
		}catch(StudentNotFound s) {
			System.out.println("Student Not Found");
			CRSApplication.main(null);
		}
		
	}
	
	/**
	 * View how many courses a student has registered
	 * @param id
	 * @throws StudentNotApproved
	 */
	public void viewCourses(int id)throws StudentNotFound {
		try {
			int v = st.viewCourses(id);
		if (v == 0) {
			throw new StudentNotFound();
		}
		}catch(StudentNotFound s) {
			System.out.println("Student Not Found");
			CRSApplication.main(null);
		}
		
	}
	/**
	 * Student Paying Fees
	 * @param id
	 * @param amount
	 * @param pay_type
	 * @throws StudentNotFound
	 */
	
	public void payFee(int id, int amount, String pay_type)throws StudentNotFound {
		try {
			int v = st.pay_fee(id, amount, pay_type);
		if (v == 0) {
			throw new StudentNotFound();
		}
		}catch(StudentNotFound s) {
			System.out.println("Student Not Found");
			CRSApplication.main(null);
		}
		
		/**
		 * Check Approval of the student
		 * @param name
		 * @throws StudentNotApproved
		 */
			
		
	}
	public void check_appr(String u_name) throws StudenNotApproved{
		try {
			int v = st.check_approval(u_name);
		if (v == 0) {
			throw new StudenNotApproved();
		}
		}catch(StudenNotApproved s) {
			System.out.println("Student Not Approved");
			CRSApplication.main(null);
		}
}
	
	/**
	 * Update the current registered course with new course
	 * @param st_id
	 * @param course_name
	 * @param new_course
	 */
		
	public void update_already_registered_course(int st_id, String course_name, String new_course) {
		int v = st.update_already_registered_course(st_id, course_name, new_course);
		if (v == 0)
			System.out.println("Course not found");
		else {
			System.out.println("Your New Course " + new_course + " has been updated in the database");
			st.viewCourses(st_id);
		}
	}
}
