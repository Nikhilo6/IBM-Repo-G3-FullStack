/**
 * 
 */
package com.crs.ibm.bean;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class Admin {
	
	/**
	 * @return the courses
	 */
	public int getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(int courses) {
		this.courses = courses;
	}
	/**
	 * @return the stud_id
	 */
	public int getStud_id() {
		return stud_id;
	}
	/**
	 * @param stud_id the stud_id to set
	 */
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	/**
	 * @return the prof_id
	 */
	public int getProf_id() {
		return prof_id;
	}
	/**
	 * @param prof_id the prof_id to set
	 */
	public void setProf_id(int prof_id) {
		this.prof_id = prof_id;
	}
	private int courses;
	private int stud_id;
	private int prof_id;
	
}
