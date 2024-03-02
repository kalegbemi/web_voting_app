package com.capstone_project.web_voting_app.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class UserRegistrationRequest {
    @Column(name = "first_name")
    @Length(min = 4, max = 36, message = "Enter your first name")
    @NotNull(message = "first name can't be null")
    @NotBlank(message = "first name can't be blank")
    private String firstName;

    @Column(name = "last_name")
    @Length(min = 4, max = 36, message = "Enter your last name")
    @NotNull(message = "last name can't be null")
    @NotBlank(message = "last name can't be blank")
    private String lastName;

    @NotNull(message = "Date of birth can't be null")
    @NotBlank(message = "Date of birth can't be blank")
    @FutureOrPresent
    private LocalDate DOB;

    @Email(message = "Enter a valid email")
    private String email;

    @NotNull
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")
    private String password;
}
