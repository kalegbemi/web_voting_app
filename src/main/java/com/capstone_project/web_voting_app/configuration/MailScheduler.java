package com.capstone_project.web_voting_app.configuration;

import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.model.Voter;
import com.capstone_project.web_voting_app.repository.CandidateRepository;
import com.capstone_project.web_voting_app.repository.ElectionRepository;
import com.capstone_project.web_voting_app.repository.VoterRepository;
import com.capstone_project.web_voting_app.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MailScheduler {




    private final EmailService emailService;
    private final ElectionRepository electionRepository;
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    @Scheduled(cron = "0 30 20 * * *")
    public void sendMailBeforeElection(){

        List<Election> elections = electionRepository.findAll();
        List<Voter> voters = voterRepository.findAll();
        List<Candidate> candidates = candidateRepository.findAll();

        for(Election e : elections){
            if(LocalDate.now().plusDays(1).equals(e.getStartDate().toLocalDate()))
//            if(LocalTime.now().getHour() == e.getStartDate().getHour())
            {
                voters.forEach(v -> {
                    String name = v.getFirstName().concat(" " + v.getLastName());
                    emailService.sendMessage24Hrbefore(v.getEmail(), name, e.getTitle(), e.getStartDate());
                });
                for (Candidate c : candidates){
                    String name = c.getFirstName().concat(" "+c.getLastName());
                    emailService.sendMessage24Hrbefore(c.getEmail(),name,e.getTitle(),e.getStartDate());
                }
            }
        }

    }



}
