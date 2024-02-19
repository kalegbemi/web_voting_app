package com.capstone_project.web_voting_app.repository;

import com.capstone_project.web_voting_app.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface AdminRepository extends JpaRepository<Admin, Integer> {

        Optional<Admin> findByEmail(String email);
}
