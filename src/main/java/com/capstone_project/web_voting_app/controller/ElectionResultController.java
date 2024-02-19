package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.service.ElectionResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ElectionResultController {

    @Autowired
    public final ElectionResultService electionResultService;
    @GetMapping("/result/{candidateId}/{electionId}")
    public Map<String,Integer> getTotalResult(@PathVariable("candidateId") long candidateId, @PathVariable("electionId") long electionId) {

       return electionResultService.getTotalResult(candidateId,electionId);
    }

}
