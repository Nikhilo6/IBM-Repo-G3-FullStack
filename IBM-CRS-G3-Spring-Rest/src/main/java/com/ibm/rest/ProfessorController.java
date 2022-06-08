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

import com.ibm.exception.StudentNotFound;
import com.ibm.exception.StudentsNotEnrolled;
import com.ibm.service.ProfessorInterface;

/**
 * @author Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorInterface professorInterface;

	
	/**
	 * Shows enrolled students
	 * @return List with enrolled students
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(path = "/viewEnrolledStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewCourse() throws StudentsNotEnrolled{
		List<String> student_list = professorInterface.viewEnrolledStudents();
		if (student_list == null) {
			return new ResponseEntity<String>("There are no students enrolled.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student_list, HttpStatus.OK);
    }
	
	/**
	 * Adding grade of a student
	 * @param id(student)
	 * @param grade
	 * @return message that grade has been added or else student not found
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(path = "/addGrades/{id}/{grade}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity addgrade(@PathVariable("id") int id, @PathVariable("grade") String grade) throws StudentNotFound{
		boolean ad = professorInterface.addGrades(id, grade);
		if (ad == false) {
			return new ResponseEntity<String>("Student Not Found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(" Grade " + grade + " has been added to studentID " + id, HttpStatus.OK);
    }
	
	/**
	 * Shows Courses Available
	 * @return List with Courses Available
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(path = "/viewCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewCourse1(){
		List<String> course_list = professorInterface.viewCourse();
		if (course_list== null) {
			return new ResponseEntity<String>("Course Not Found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(course_list, HttpStatus.OK);
    }
}
