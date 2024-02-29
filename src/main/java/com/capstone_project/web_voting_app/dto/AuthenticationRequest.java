package com.capstone_project.web_voting_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @Email(message = "Email must be valid")
    private String username;

    @Length(min = 8, message = "password must be at least 8 characters long")
    @NotBlank(message = "password can't be blank")
    private String password;

}
