package com.capstone_project.web_voting_app.dto;

import com.capstone_project.web_voting_app.enom.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CandidateRequest {

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

    @Column(name = "party_affiliation")
    @NotNull(message = "party affiliation can't be null")
    @NotBlank(message = "party affiliation can't be blank")
    private String  partyAffiliation;


    @NotNull(message = "Position can't be null")
    @NotBlank(message = "Position can't be blank")
    private String position;

    @Email(message = "Enter a valid email")
    private String email;

    private Role role = Role.VOTER;
}
