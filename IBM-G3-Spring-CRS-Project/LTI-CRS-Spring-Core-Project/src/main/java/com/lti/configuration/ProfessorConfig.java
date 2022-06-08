/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.service.ProfessorInterface;
import com.lti.service.ProfessorService;
import com.lti.service.ProfessorsService;


/**
 * @author 003NZS744
 *
 */
public class ProfessorConfig {
	@Bean(name="professorBean")
	public ProfessorInterface admin() {
		return new ProfessorsService();
	}
}
