package com.capstone_project.web_voting_app.configuration;

import com.capstone_project.web_voting_app.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ElectionScheduler {
    @Autowired
    private ElectionService electionService;

    @Scheduled(cron = "0 */2 * * * *")
    public void updateElectionBaseOnDate(){
        electionService.updateElectionStatusBaseOnDate();
    }

}
