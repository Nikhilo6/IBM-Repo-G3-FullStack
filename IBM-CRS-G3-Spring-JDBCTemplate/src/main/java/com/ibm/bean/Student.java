/**
 * 
 */
package com.ibm.bean;
/**
 * @author 003NZS744
 *
 */
public class Student{
	private int id;
	private String stud_name;
	private String address;
	private String email;
	private String grade;
	private int admin_approval ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getAdmin_approval() {
		return admin_approval;
	}
	public void setAdmin_approval(int admin_approval) {
		this.admin_approval = admin_approval;
	}

}
