/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003NZS744
 *
 */
public class CourseRegister {
	private int register_id;
	private int stud_id;
	public int getRegister_id() {
		return register_id;
	}
	public void setRegister_id(int register_id) {
		this.register_id = register_id;
	}
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getCourse1() {
		return course1;
	}
	public void setCourse1(String course1) {
		this.course1 = course1;
	}
	public String getCourse2() {
		return course2;
	}
	public void setCourse2(String course2) {
		this.course2 = course2;
	}
	public String getCourse3() {
		return course3;
	}
	public void setCourse3(String course3) {
		this.course3 = course3;
	}
	public String getCourse4() {
		return course4;
	}
	@Override
	public String toString() {
		return "CourseRegister [register_id=" + register_id + ", stud_id=" + stud_id + ", course1=" + course1
				+ ", course2=" + course2 + ", course3=" + course3 + ", course4=" + course4 + ", course5=" + course5
				+ "]";
	}
	public void setCourse4(String course4) {
		this.course4 = course4;
	}
	public String getCourse5() {
		return course5;
	}
	public void setCourse5(String course5) {
		this.course5 = course5;
	}
	private String course1;
	private String course2;
	private String course3;
	private String course4 ;
	private String course5;
}
