package com.capstone_project.web_voting_app.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Builder
@Data
public class AdminRegisterRequest {
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()+]).{8,}$")
    private String password;

    @Column(name = "full_name")
    @Length(min = 6, max = 36, message = "Enter your first and last name")
    private String fullName;

    @Email(message = "Enter a valid email")
    private String email;

}
