package com.capstone_project.web_voting_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SendOtherMailDto {
    private String body;
    private String subject;
}
