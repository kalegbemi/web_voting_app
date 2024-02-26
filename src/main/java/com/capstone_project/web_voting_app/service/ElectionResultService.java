package com.capstone_project.web_voting_app.service;

import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.model.Vote;
import com.capstone_project.web_voting_app.repository.CandidateRepository;
import com.capstone_project.web_voting_app.repository.ElectionRepository;
import com.capstone_project.web_voting_app.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class ElectionResultService {

    private final VoteRepository voteRepository;
    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;



    public Map<String, Serializable> getTotalResult(long candidateId, long electionId) {
        Integer electionResult = voteRepository.findAllByElectionId(electionId).size();
        Candidate candidate = candidateRepository.findCandidateById(candidateId);
        Integer candidateResult = voteRepository.findByCandidate(candidate).size();
       Election election = electionRepository.findById(electionId).orElseThrow();
        String name = candidate.getFirstName() + " " + candidate.getLastName();
        return Map.of("Candidate name ", name,
                "Candidate result", candidateResult,
                "Total vote for " + election.getTitle(), electionResult,
                "Party", candidate.getPartyAffiliation()
        );
    }

    public List<Map<String, Serializable>> getTotalResultByCandidate(long electionId) {
        List<Vote> votes = voteRepository.findAllByElectionId(electionId);
        List<Map<String, Serializable>> mapList = new ArrayList<>();

        Integer electionResult = votes.size();
        {
        for (Vote v:votes) {
            Candidate candidate = v.getCandidate();
            Integer candidateResult = voteRepository.findByCandidate(candidate).size();
            Election election = electionRepository.findById(electionId).orElseThrow();
            String name = candidate.getFirstName() + " " + candidate.getLastName();
            Map<String, Serializable> map = Map.of("Candidate name ", name,
                    "Candidate result", candidateResult,
                    "Total vote for " + election.getTitle(), electionResult,
                    "Party", candidate.getPartyAffiliation()

            );
            mapList.add(map);
        }
        return mapList.stream().distinct().toList();

    }

}
}
