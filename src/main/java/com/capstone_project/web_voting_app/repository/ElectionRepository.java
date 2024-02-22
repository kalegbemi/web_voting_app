package com.capstone_project.web_voting_app.repository;

import com.capstone_project.web_voting_app.enom.Status;
import com.capstone_project.web_voting_app.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {
    Election findByTitle(String title);
    List<Election> findByStatus(Status status);

    @Modifying
    @Query("UPDATE Election e set e.status = CASE " +
            "WHEN e.startDate > CURRENT_TIMESTAMP THEN 'UPCOMING' " +
            "WHEN e.startDate <= current_timestamp AND e.endDate >= current_timestamp THEN 'ONGOING' " +
            "ELSE 'COMPLETED' END ")
    void updateElectionStatusBaseOnDates();

}