package com.capstone_project.web_voting_app.model;

import com.capstone_project.web_voting_app.enom.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String  partyAffiliation;
    private String position;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.VOTER;
}
