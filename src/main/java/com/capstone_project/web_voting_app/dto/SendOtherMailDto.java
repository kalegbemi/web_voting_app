package com.capstone_project.web_voting_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SendOtherMailDto {

    @NotNull
    @NotBlank
    private String body;

    @NotNull
    @NotBlank
    private String subject;
}
