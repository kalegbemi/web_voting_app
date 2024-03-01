package com.capstone_project.web_voting_app.dto;

import com.capstone_project.web_voting_app.enom.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CandidateRequest {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String  partyAffiliation;

    @NotNull
    private String position;

    @Email

    private String email;
    private Role role = Role.VOTER;
}
