package com.ibm.application;



import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@Configurable
@EnableAutoConfiguration
@ComponentScan({"com.ibm.*"})
@EnableWebMvc 
public class IbmCrsG3SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmCrsG3SpringRestApplication.class, args);
		}
}


