package com.ibm.bean;

public class Catalog {
	
	private int catalog_id;
	public int getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public int getSemseter() {
		return semseter;
	}
	public void setSemseter(int semseter) {
		this.semseter = semseter;
	}
	private int course_id;
	private String course_name;
	private String course_type;
	private int semseter;
}
