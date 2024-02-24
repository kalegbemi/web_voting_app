package com.capstone_project.web_voting_app.controller;


import com.capstone_project.web_voting_app.dto.CandidateEmailDetails;
import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.model.Voter;
import com.capstone_project.web_voting_app.repository.CandidateRepository;
import com.capstone_project.web_voting_app.repository.ElectionRepository;
import com.capstone_project.web_voting_app.repository.VoterRepository;
import com.capstone_project.web_voting_app.service.EmailService;
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
public class EmailController {
    @Autowired
    private EmailService emailService;

    private final ElectionRepository electionRepository;
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    @GetMapping("/send")
    public String sendmail() {
        CandidateEmailDetails details = CandidateEmailDetails.builder()
                .to("kydjams@yahoo.com")
                .party("APC")
                .name("Kayode J Alegbemi")
                .position("PRESIDENCY")
                .role("Candidate")
                .build();
        emailService.sendCandidateMessage(details);
        return "message sent successfully";
    }

    @GetMapping("/send1")
    public String sendmail1() {
        String to = ("kydjams@yahoo.com");

        String name = "Kayode J Alegbemi";

        String role = "Candidate";

        emailService.sendMessage(to,name,role);
        return "message sent successfully";
    }
    @GetMapping("/sendmail")
    public void sendMailBeforeElection() {

        List<Election> elections = electionRepository.findAll();
        List<Voter> voters = voterRepository.findAll();
        List<Candidate> candidates = candidateRepository.findAll();

        for (Election e : elections) {
            /*if(LocalDateTime.now().plusHours(24) == e.getStartDate())*/
           // if (LocalDateTime.now().plusMinutes(2) == e.getStartDate()) {
                for (Voter v : voters) {
                    String name = v.getFirstName().concat(" " + v.getLastName());
                    emailService.sendMessage24Hrbefore(v.getEmail(), name, e.getTitle(), e.getStartDate());
                }
                for (Candidate c : candidates) {

                    String name = c.getFirstName().concat(" " + c.getLastName());
                    emailService.sendMessage24Hrbefore(c.getEmail(), name, e.getTitle(), e.getStartDate());
                }
            }
       // }
    }
}
