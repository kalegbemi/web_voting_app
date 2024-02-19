package com.capstone_project.web_voting_app.repository;

import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.model.Vote;
import com.capstone_project.web_voting_app.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Vote findByVoterId(long id);
    List<Vote> findByVoter(Voter voter);
    List<Vote> findAllByElectionId(long electionId);
    List<Vote> findByCandidate(Candidate candidate);

}
