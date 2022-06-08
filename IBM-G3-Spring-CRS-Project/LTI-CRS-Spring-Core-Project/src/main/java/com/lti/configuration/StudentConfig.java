/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.service.StudentInterface;
import com.lti.service.StudentService;

/**
 * @author 003NZS744
 *
 */
public class StudentConfig {
	@Bean(name="studentBean")
	public StudentInterface admin() {
		return new StudentService();
	}
}
