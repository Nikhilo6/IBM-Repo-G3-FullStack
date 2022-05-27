/**
 * 
 */
package com.crs.ibm.service;

import java.util.List;

import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.StudenNotApproved;
import com.crs.ibm.exception.StudentNotFound;

/**
 * @author Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public interface StudentInterface{
		

	public void registerCourse(int id, List<String> ls) throws StudenNotApproved;

	public void dropCourse(int st_id,int crs_id) throws StudentNotFound;
	
	public void viewReportCard(int id) throws StudentNotFound;
	
	public void viewCourses(int id) throws StudentNotFound; 
	
	public void addCourse(int stud_id, int course_id) throws CourseNotFound, StudenNotApproved;
	
	public void payFee(int id, int amount, String pay_type) throws StudentNotFound;
	public void check_appr(String u_name) throws StudenNotApproved;
	public void update_already_registered_course(int st_id, String course_name, String new_course);
}
