package com.capstone_project.web_voting_app.repository;


import com.capstone_project.web_voting_app.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {


    Voter findByEmail(String username);
}