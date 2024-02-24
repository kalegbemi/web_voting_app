package com.capstone_project.web_voting_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class WebVotingAppApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebVotingAppApplication.class, args);
    }
}
