package com.capstone_project.web_voting_app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoteRequest {
    private Long voterId;
    private Long candidateId;
    private Long electionId;
}
