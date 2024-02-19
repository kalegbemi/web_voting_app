package com.capstone_project.web_voting_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Builder
@Data
public class ElectionRequest {
    private String Title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
