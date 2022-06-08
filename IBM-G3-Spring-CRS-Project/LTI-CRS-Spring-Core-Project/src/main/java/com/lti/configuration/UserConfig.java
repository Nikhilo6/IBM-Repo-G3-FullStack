/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.service.UserInterface;
import com.lti.service.UserService;

/**
 * @author 003NZS744
 *
 */
public class UserConfig {
	@Bean(name="userBean")
	public UserInterface admin() {
		return new UserService();
	}
}
