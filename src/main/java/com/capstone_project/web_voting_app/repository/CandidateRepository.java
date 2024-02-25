package com.capstone_project.web_voting_app.repository;

import com.capstone_project.web_voting_app.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    Candidate findCandidateById(long candidateId);
}
