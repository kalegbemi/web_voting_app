package com.capstone_project.web_voting_app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class ElectionRequest {

    @NotNull
    @NotBlank
    @NotEmpty
    private String Title;

    @FutureOrPresent
    @NotNull
    private LocalDateTime startDate;
    
    @Future
    @NotNull
    private LocalDateTime endDate;
}
