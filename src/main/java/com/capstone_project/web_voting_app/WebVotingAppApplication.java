package com.capstone_project.web_voting_app;

import com.capstone_project.web_voting_app.dto.AdminRegisterRequest;
import com.capstone_project.web_voting_app.service.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableCaching
public class WebVotingAppApplication {

private Boolean hasRun = true;
    @Bean

    CommandLineRunner commandLineRunner(AdminService adminService){
        return args -> {
            if (!hasRun) {
            AdminRegisterRequest adminRegisterRequest = AdminRegisterRequest.builder()
                    .email("yusuf@yahoo.com")
                    .fullName("Abiodun George")
                    .password("Abiodun231@")
                    .build();

                adminService.register(adminRegisterRequest);
                hasRun = true;
            }
        };

    }


    public static void main(String[] args) {
        SpringApplication.run(WebVotingAppApplication.class, args);
    }
}
