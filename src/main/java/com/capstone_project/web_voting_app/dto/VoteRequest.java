package com.capstone_project.web_voting_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VoteRequest {
    private Long voterId;
    private Long candidateId;
    private Long electionId;
}
