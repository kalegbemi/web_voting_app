package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.dto.CandidateRequest;
import com.capstone_project.web_voting_app.model.Candidate;
import com.capstone_project.web_voting_app.service.CandidateService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@SecurityRequirement(name = "bearer auth")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @PostMapping("/saveCandidate")
    public Candidate registerCandidate(@RequestBody @Valid CandidateRequest request) {
        return candidateService.registerCandidate(request);
    }
    @GetMapping("/candidate/{id}")
    public Candidate getCandidateById(@PathVariable long id){

        return candidateService.getCandidateById(id).getBody().orElseThrow();
    }

    @GetMapping("/allcandidate")
    public List<Candidate> getAllCandidate() {

        return candidateService.getAllCandidate();
    }

    @PutMapping("/candidate/{id}")
    public String updateCandidate(@PathVariable long id, @RequestBody @Valid Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }
    @DeleteMapping("/candidate/{id}")
    public String deleteCandidate(@PathVariable long id) {
        return candidateService.deleteCandidate(id);
    }



}
