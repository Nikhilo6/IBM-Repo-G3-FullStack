/**
 * 
 */
package com.crs.ibm.bean;

/**
 * @author  Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
public class Professors {
	
	private int prof_id;
	private String profName;
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
	/**
	 * @return the profName
	 */
	public String getProfName() {
		return profName;
	}
	/**
	 * @param profName the profName to set
	 */
	public void setProfName(String profName) {
		this.profName = profName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
	
}
