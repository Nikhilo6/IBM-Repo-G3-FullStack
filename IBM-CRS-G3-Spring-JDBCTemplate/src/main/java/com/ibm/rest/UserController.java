package com.ibm.rest;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.exception.NewUserProperName;
import com.ibm.exception.UserNotFound;
import com.ibm.service.UserInterface;

/**
 * @author Nikhil, Anas, Kranthi, Ravi, Harrish, Lokesh
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserInterface userInterface;
	
	
	/**
	 * Add new user
	 * @param id
	 * @param role
	 * @param name
	 * @param password
	 * @return a message that user has been added
	 */
	

	@RequestMapping(path = "/newuser/{role}/{id}/{name}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseMessage> newuser(@PathVariable("id") String id, @PathVariable("role") String role,@PathVariable("name") String name, @PathVariable("password") String password) throws NewUserProperName{
		
		userInterface.new_user(id, name, password);
		if (role.equals("student")) {
			userInterface.add_stud(name, id);
		}
		else if (role.equals("professor"))
			userInterface.add_prof(name, id);
		else if(role.equals("admin"))
			userInterface.add_admin(name, id);
			
		if (userInterface == null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("User Not Added Try Again."));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("User " + name + " been Added."));
     }
	
	/**
	 * Change password of a user
	 * @param id
	 * @param password
	 * @return a message that password has been changed
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/passwordchange/{id}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity pw_change(@PathVariable("id") String id, @PathVariable("password") String password) throws UserNotFound{
		boolean cs = userInterface.password_change(id, password);
		if (cs == false) {
			return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Passowrd for ID " + id + " has been changed.", HttpStatus.OK);
	}
	
	
	/**
	 * Login of a user
	 * @param id
	 * @param password
	 * @return List with username and password
	 */
	
	@RequestMapping(path = "/getusernamepassword/{id}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseMessage> get_username(@PathVariable("id") String id, @PathVariable("password") String password) throws UserNotFound{
		List<String> cs = userInterface.login(id, password);
		if (cs.isEmpty() || cs == null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(" User Not Found "));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("User Found. Successfuly Logged in."));
	}
}
