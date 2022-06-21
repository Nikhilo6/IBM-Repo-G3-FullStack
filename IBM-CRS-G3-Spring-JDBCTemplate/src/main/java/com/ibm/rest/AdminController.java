/**
 * 
 */
package com.ibm.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.exception.CourseNotFound;
import com.ibm.exception.ProfessorNotFound;
import com.ibm.exception.StudentNotFound;
import com.ibm.service.AdminInterface;

/**
 * @author Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private AdminInterface adminInterface;
	
	
	/**
	 * Add course into catalog and course tables
	 * @param id
	 * @param name
	 * @return List with courses
	 */
	
	
	@RequestMapping(path = "/addcourse/{name}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseMessage> addcourse(@PathVariable("name") String name, @PathVariable("id") int id) throws CourseNotFound{
		boolean cs = adminInterface.addCourse(name, id);
		if (cs == false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Course " + name + " was not added"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Course " + name + " has been added"));
    }
	
	
	/**
	 * Delete course into catalog and course tables
	 * @param id
	 * @param name
	 * @return List with courses
	 */
	
	
	@RequestMapping(path = "/deletecourse/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseMessage> deletecourse(@PathVariable("id") int id) throws CourseNotFound{
		boolean cs = adminInterface.removeCourse(id);
		if (cs == false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Course not Found"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Course " + id + " has been removed"));
    }
	
	
	/**
	 * Assign course to a professor 
	 * @param pid(professor id)
	 * @param cid(course id)
	 * @return message that course has been assigned or else shows professor not found
	 */
	
	
	@RequestMapping(path = "/assigncourseprofessor/{prof_id}/{course_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseMessage> assigncourseprof(@PathVariable("prof_id") int prof_id, @PathVariable("course_id") int course_id) throws ProfessorNotFound{
		boolean cs = adminInterface.assignCourseProfessor(prof_id, course_id);
		if (cs == false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Professor not Found"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("CourseID " + course_id + " has been assigned to professorID " + prof_id));

    }
	
	/**
	 * Approve student 
	 * @param id
	 * @return message that student has been approved or else shows student not found
	 */
	
	
	@RequestMapping(path = "/studentapproval/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseMessage> studentapproval(@PathVariable("id") int id) throws StudentNotFound{
		boolean cs = adminInterface.set_admin_approval(id);
		if (cs == false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Student not Found"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("StudentID " + id + " has been approved"));
    }
	
	/**
	 * Add professors 
	 * @param pid
	 * @param name
	 * @return message that professor has been added or else shows professor not found
	 */
	
	@RequestMapping(path = "/addprof/{prof_id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseMessage> addprof(@PathVariable("prof_id") String prof_id, @PathVariable("name") String name) throws ProfessorNotFound{
		boolean cs = adminInterface.addProfessor(prof_id, name);
		if (cs == false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Professor not Found"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Professor " + name + " has been added"));
    }
}
