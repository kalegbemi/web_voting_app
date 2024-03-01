package com.capstone_project.web_voting_app.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class UserRegistrationRequest {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate DOB;

    @Email
    private String email;

    @NotNull
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")
    private String password;
}
