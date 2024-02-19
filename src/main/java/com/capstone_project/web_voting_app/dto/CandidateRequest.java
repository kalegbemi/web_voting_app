package com.capstone_project.web_voting_app.dto;

import com.capstone_project.web_voting_app.enom.Role;
import lombok.Data;

@Data
public class CandidateRequest {
    private String firstName;
    private String lastName;
    private String  partyAffiliation;
    private String position;
    private String email;
    private Role role = Role.VOTER;
}
