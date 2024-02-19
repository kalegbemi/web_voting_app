package com.capstone_project.web_voting_app.dto;

import lombok.Data;

@Data
public class CandidateRequest {
    private String firstName;
    private String lastName;
    private String  partyAffiliation;
    private String position;
    private String email;
}
