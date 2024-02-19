package com.capstone_project.web_voting_app.service;

import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.repository.CandidateRepository;
import com.capstone_project.web_voting_app.repository.ElectionRepository;
import com.capstone_project.web_voting_app.repository.ElectionResultRepository;
import com.capstone_project.web_voting_app.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElectionResultService {

    @Autowired
    private final ElectionResultRepository electionResultRepository;
    @Autowired
    private final CandidateRepository candidateRepository;
    @Autowired
    private final ElectionRepository electionRepository;

   // private final VoteRepository voteRepository;

    public Map<String,Integer> getTotalResult(long candidateId, long electionId) {
        Integer electionResult = electionResultRepository.findByElectionId(electionId).size();
        Integer candidateResult = electionResultRepository.findByCandidateId(candidateId).size();
        Election election = electionRepository.findById(electionId).orElseThrow();
        Candidate candidate = candidateRepository.findCandidateById(candidateId);
        String name = candidate.getFirstName() + " " + candidate.getLastName();
        return Map.of(name, candidateResult, election.getTitle(), electionResult);
    }

}
