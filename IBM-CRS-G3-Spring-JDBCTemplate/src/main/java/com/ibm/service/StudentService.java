/**
 * 
 */
package com.ibm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.dao.StudentDAOInterface;
import com.ibm.exception.CourseNotFound;
import com.ibm.exception.StudenNotApproved;
import com.ibm.exception.StudentNotFound;




/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@Service
public class StudentService implements StudentInterface{
	
	@Autowired
	StudentDAOInterface st;
	
	/**
	 * Add Course to CourseRegister Table
	 * @param stud_id
	 * @param course_id
	 * @throws CourseNotFound, StudentNotApproved
	 */
	
	public boolean addCourse(int stud_id, String course) throws CourseNotFound, StudenNotApproved {

				
				int v = st.add_course(stud_id, course);
					if (v == 0) 
						return false;
					return true;

	
	}
	/**
	 * Add Student to CourseRegister Table
	 * @param stud_id
	 * @param ls
	 */
	public List<String> registerCourse(int id, String c1, String c2, String c3, String c4) {
		List<String> v = st.register(id, c1, c2, c3, c4);
		if (v== null) {
			return null;
	        }
		else
			return v;
		}
	/**
	 * Delete Course from CourseRegister Table
	 * @param st_id
	 * @param cr_id
	 * @throws StudentNotApproved
	 */

	public boolean dropCourse(int st_id,String cr_id) throws StudentNotFound{
		
			int v = st.delete_course(st_id, cr_id);
		if (v == 0) 
			return false;
		return true;
		
	}
	
	/**
	 * View Grade of a student
	 * @param id
	 * @throws StudentNotFound
	 */
	public String viewReportCard(int id) throws StudentNotFound {
		try {
			String v = st.view_reportCard(id);
		if (v == null) {
			throw new StudentNotFound();
		}
		else
			return v;
		}catch(StudentNotFound s) {
		}
		return null;
		
	}
	
	/**
	 * View how many courses a student has registered
	 * @param id
	 * @return 
	 * @throws StudentNotApproved
	 */
	public List<String> viewCourses(int id)throws StudentNotFound {
		try {
			
			List<String> v = st.viewCourses(id);
		if (v == null) {
			throw new StudentNotFound();
		}
		else
			return v;
		}catch(StudentNotFound s) {
		}
		return null;
	}
	/**
	 * Student Paying Fees
	 * @param id
	 * @param amount
	 * @param pay_type
	 * @throws StudentNotFound
	 */
	
	public boolean payFee(int id, int amount, String pay_type)throws StudentNotFound {
			int v = st.pay_fee(id, amount, pay_type);
		if (v == 0) {
			return false;
		}
		return true;
		
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
		}
}
	
	/**
	 * Update the current registered course with new course
	 * @param st_id
	 * @param course_name
	 * @param new_course
	 * @return list
	 */
		
	public List<String> update_already_registered_course(int st_id, String course_name, String new_course) {
		List<String> v = st.update_already_registered_course(st_id, course_name, new_course);
		if (v == null)
			return null;
		else {
			return v;
		}	
	}
}
