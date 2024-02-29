package com.capstone_project.web_voting_app.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AdminUpdateRequest {
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()+]).{8,}$",
            message = "password most be " +
            "aleast 8 characters one of which must be an uppercase," +
            " lowercase, numbers and these special characters")
    private String password;

    @Column(name = "full_name")
    @Length(min = 6, max = 36, message = "Enter your first and last name")
    @NotNull(message = "full name can't be null")
    @NotBlank(message = "full name can't be blank")
    private String fullName;

    @Email(message = "Enter a valid email")
    private String email;

}
