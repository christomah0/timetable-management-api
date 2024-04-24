package com.ihm.timetablemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;

@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class,
		SessionAutoConfiguration.class
})
public class TimetableManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetableManagementApplication.class, args);
	}

}
