package com.capstone_project.web_voting_app.dto;

import lombok.Data;

@Data
public class AdminUpdateRequest {
    private String password;
    private String fullName;
    private String email;

}
