package com.capstone_project.web_voting_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebVotingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebVotingAppApplication.class, args);
	}

}
