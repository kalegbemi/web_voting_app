package com.capstone_project.web_voting_app.dto;

import com.capstone_project.web_voting_app.model.Election;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ElectionPageableResponse {
    private List<Election> content;
    private int pageNo;
    private int pageSize;
    private int totalSize;
    private int totalPages;
    private boolean last;

}
