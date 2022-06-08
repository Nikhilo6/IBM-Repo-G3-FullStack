/**
 * 
 */
package com.ibm.rest;

import java.util.List;


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
import com.ibm.exception.StudenNotApproved;
import com.ibm.exception.StudentNotFound;
import com.ibm.service.StudentInterface;


/**
 * @author Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentInterface studentInterface;
	
	
	/**
	 * Add courses of a student into CourseRegister
	 * @param id
	 * @param name
	 * @param name2
	 * @param name3
	 * @param name4
	 * @return List with courses
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(path = "/post/registercourse/{id}/{name}/{name2}/{name3}/{name4}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity registerCourse(@PathVariable("id") int id,@PathVariable("name") String course1,
			@PathVariable("name2") String course2, @PathVariable("name3") String course3, @PathVariable("name4") String course4)
			throws StudenNotApproved {
		List<String> course_list = studentInterface.registerCourse(id, course1, course2, course3, course4);
		if (course_list == null) {
			return new ResponseEntity("Student has not been approved " + id, HttpStatus.NOT_FOUND);
		    }
		return new ResponseEntity("Courses Registered"  + course_list, HttpStatus.OK);
		}
	
	
	/**
	 * Viewing courses of a particular student
	 * @param id
	 * @return List with courses
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/viewcourse/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewCourse(@PathVariable("id") int id) throws StudentNotFound {
		List<String> course_list = studentInterface.viewCourses(id);
		if (course_list == null) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(course_list, HttpStatus.OK);
    }
	
	
	/**
	 * Update courses of a particular student
	 * @param id
	 * @param old_course
	 * @param new_course
	 * @return List with courses
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/update/course/{id}/{old_course}/{new_course}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity update(@PathVariable("id") int id,@PathVariable("old_course") String old_course, @PathVariable("new_course") String new_course) throws StudentNotFound {
		
		List<String> course_list = studentInterface.update_already_registered_course(id, old_course, new_course);
		if (course_list == null) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Updated Courses"  + course_list, HttpStatus.OK);
    }
	
	/**
	 * Add new course of students
	 * @param id
	 * @param course
	 * @return message that course has been added or else course not found
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/post/addnewcourse/{id}/{course}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity addCourse(@PathVariable("id") int id,@PathVariable("course") String course) throws CourseNotFound, StudenNotApproved {
		
		boolean ad = studentInterface.addCourse(id, course);
		if (ad == false)
			return new ResponseEntity("Course Not Found " + course, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Course " + course + " has been added",HttpStatus.OK);
    }
	
	/**
	 * Add new course of students
	 * @param id
	 * @param course
	 * @return message that course has been deleted or else course not found
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/delete/course/{id}/{course}")
	public ResponseEntity deleteCourse(@PathVariable("id") int id,@PathVariable("course") String course) throws StudentNotFound {
		
		boolean v = studentInterface.dropCourse(id, course);
		if (v == false)
			return new ResponseEntity("Course Not Found " + course, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Course " + course + " has been deleted",HttpStatus.OK);
    }
	
	
	/**
	 * Add new course of students
	 * @param id
	 * @param amount
	 * @param type
	 * @return message that payment has been done or else student not found
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/payfee/{id}/{amount}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity payfee(@PathVariable("id") int id,@PathVariable("amount") int amount, @PathVariable("type") String type) throws StudentNotFound {
		
		boolean ad = studentInterface.payFee(id, amount, type);
		if (ad == false)
			return new ResponseEntity("Student not Found ID " + id, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Payment " + amount + " has been paid by studentID " + id, HttpStatus.OK);
    }
	
	
	/**
	 * Add new course of students
	 * @param id
	 * @return grade of a student or else student not found
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/viewreport/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewreport(@PathVariable("id") int id) throws StudentNotFound {
		
		String ad = studentInterface.viewReportCard(id);
		if (ad == null)
			return new ResponseEntity("Student not Found ID " + id, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Report card of student " + id + " is "  + ad,HttpStatus.OK);
    }
}
