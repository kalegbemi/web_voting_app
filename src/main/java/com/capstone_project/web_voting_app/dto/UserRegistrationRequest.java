package com.capstone_project.web_voting_app.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class UserRegistrationRequest {

    private String firstName;

    private String lastName;

    private LocalDate DOB;

    private String email;

    private String password;
}
