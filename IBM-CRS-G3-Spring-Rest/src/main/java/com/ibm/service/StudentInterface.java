/**
 * 
 */
package com.ibm.service;

import java.util.List;



import org.springframework.stereotype.Component;
import com.ibm.exception.CourseNotFound;
import com.ibm.exception.StudenNotApproved;
import com.ibm.exception.StudentNotFound;


/**
 * @author Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Component
public interface StudentInterface{
		
	public boolean dropCourse(int st_id,String c1) throws StudentNotFound;
	
	public String viewReportCard(int id) throws StudentNotFound;
	
	public List<String> viewCourses(int id) throws StudentNotFound; 
	
	public boolean addCourse(int stud_id, String c1) throws CourseNotFound, StudenNotApproved;
	
	public boolean payFee(int id, int amount, String pay_type) throws StudentNotFound;
	
	public void check_appr(String u_name) throws StudenNotApproved;
	
	public List<String> update_already_registered_course(int st_id, String course_name, String new_course);

	public List<String> registerCourse(int id, String c1, String c2, String c3, String c4);
}
