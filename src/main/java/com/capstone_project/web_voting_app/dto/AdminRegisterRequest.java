package com.capstone_project.web_voting_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

    @AllArgsConstructor
    @Builder
    @Data
    public class AdminRegisterRequest {

        private String password;
        private String fullName;
        private String email;

    }
