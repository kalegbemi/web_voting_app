package com.capstone_project.web_voting_app.service;

import com.capstone_project.web_voting_app.dto.VoteRequest;
import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.model.Vote;
import com.capstone_project.web_voting_app.model.Voter;
import com.capstone_project.web_voting_app.repository.CandidateRepository;
import com.capstone_project.web_voting_app.repository.ElectionRepository;
import com.capstone_project.web_voting_app.repository.VoteRepository;
import com.capstone_project.web_voting_app.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private ElectionRepository electionRepository;

    @Cacheable("getVoteByElectionId")
    public ResponseEntity<Vote> getElectionById(long id) {
        return new ResponseEntity<>(voteRepository.findById(id).get(), HttpStatus.OK);
    }
    @Cacheable("getVoteByVoterId")
    public ResponseEntity<Vote> getVoteByVoterId(long Id) {
        return new ResponseEntity<>(voteRepository.findByVoterId(Id), HttpStatus.OK);
    }

    @Cacheable("allVote")
    public ResponseEntity<List<Vote>> findAllVote() {

        return new ResponseEntity<>(voteRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> castVote(VoteRequest voteRequest) {
        LocalDateTime dateTime1 = LocalDateTime.of(2024,02,4,8,00,00);
        LocalDateTime dateTime2 = LocalDateTime.of(2024,02,4,17,00,00);
        LocalDateTime votingTime = LocalDateTime.now();

        Vote vote1 = new Vote();
        Voter voter = voterRepository.findById(voteRequest.getVoterId()).orElseThrow();
        List<Vote> vote = voteRepository.findByVoter(voter);

        Election election = electionRepository.findById(voteRequest.getElectionId()).orElseThrow();
        Candidate candidate = candidateRepository.findById(voteRequest.getCandidateId()).orElseThrow();
        if (votingTime.isAfter(dateTime1) && votingTime.isBefore(dateTime2)) {
            if (isExist(vote, election.getId())){
                vote1.setVoter(voter);
                vote1.setElection(election);
                vote1.setCandidate(candidate);
                vote1.setVotingTime(votingTime);
                voteRepository.save(vote1);
                return new ResponseEntity<>("successfully voted",HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>("Already voted for this candidate",HttpStatus.BAD_REQUEST);
            }

        }
        return  new ResponseEntity<>("Voting session ended",HttpStatus.BAD_REQUEST);
    }

    private Boolean isExist(List<Vote> voteList, long electionId) {

        if (voteList.isEmpty()){
            return true;
        }

        for (Vote vote : voteList){
            if (vote.getElection().getId() == electionId) {
                return false;
            }
        }
        return true;
    }
}
