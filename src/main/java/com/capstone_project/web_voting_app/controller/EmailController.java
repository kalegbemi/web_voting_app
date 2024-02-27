package com.capstone_project.web_voting_app.controller;


import com.capstone_project.web_voting_app.dto.CandidateEmailDetails;
import com.capstone_project.web_voting_app.dto.SendOtherMailDto;
import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.model.Voter;
import com.capstone_project.web_voting_app.repository.CandidateRepository;
import com.capstone_project.web_voting_app.repository.ElectionRepository;
import com.capstone_project.web_voting_app.repository.VoterRepository;
import com.capstone_project.web_voting_app.service.EmailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/mail")
@SecurityRequirement(name = "bearer auth")
public class EmailController {
    @Autowired
    private EmailService emailService;

    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;


    @GetMapping("/send1")
    public String sendmail1() {
        String to = ("kydjams@yahoo.com");

        String name = "Kayode J Alegbemi";

        String role = "Candidate";

        emailService.sendMessage(to, name, role);
        return "message sent successfully";
    }

    @GetMapping("/sendmail")
    public void sendOtherMail(SendOtherMailDto request) {

        List<Voter> voters = voterRepository.findAll();
        List<Candidate> candidates = candidateRepository.findAll();


        for (Voter v : voters) {

            emailService.sendMessage(v.getEmail(), request.getBody(), request.getSubject());
        }
        for (Candidate c : candidates) {

            emailService.sendMessage(c.getEmail(), request.getBody(), request.getSubject());
        }
    }

}
