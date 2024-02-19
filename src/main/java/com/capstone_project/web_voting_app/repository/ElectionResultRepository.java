package com.capstone_project.web_voting_app.repository;

import com.capstone_project.web_voting_app.model.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionResultRepository extends JpaRepository<ElectionResultRepository, Long> {
    List<ElectionResult> findByCandidateId(Long candidateId);
    List<ElectionResult> findByElectionId(Long electionId);

    // List<ElectionResult> findElectionResultsByCandidateAndVote(Long candidateId
}
