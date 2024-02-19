package com.capstone_project.web_voting_app.repository;

import com.capstone_project.web_voting_app.enom.Status;
import com.capstone_project.web_voting_app.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ElectionRepository extends JpaRepository<Election, Long> {
    List<Election> findByStatus(Status status);
    Election findByTitle(String title);

}
