/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;


import com.lti.service.AdminInterface;
import com.lti.service.AdminService;


/**
 * @author 003NZS744
 *
 */
public class AdminConfig {
	
	@Bean(name="adminBean")
	public AdminInterface admin() {
		return new AdminService();
	}
}
