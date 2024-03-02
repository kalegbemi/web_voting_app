package com.capstone_project.web_voting_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VoteRequest {
    @NotNull
    @NotBlank
    private Long voterId;

    @NotBlank
    @NotNull
    private Long candidateId;

    @NotBlank
    @NotNull
    private Long electionId;
}
