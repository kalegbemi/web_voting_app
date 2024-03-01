package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.dto.UserRegistrationRequest;
import com.capstone_project.web_voting_app.model.Voter;
import com.capstone_project.web_voting_app.service.VoterService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voter")
public class VoterController {

    @Autowired
    private VoterService voterService;


    @PostMapping("/save")
    public Voter createVoter (@RequestBody @Valid UserRegistrationRequest request) {
        return voterService.saveVoter(request);
    }

    @SecurityRequirement(name = "bearer auth")
    @GetMapping("/allvoters")
    public List<Voter> getAllVoters() {

        return voterService.getAllVoters();
    }
    @SecurityRequirement(name = "bearer auth")
    @GetMapping("/voters/{id}")
    public Voter getVoterById(@PathVariable Long id){

        return voterService.getVoterById(id).orElse(null);
    }
    @SecurityRequirement(name = "bearer auth")
    @PutMapping("/voters/{id}")
    public String updateVoter(@PathVariable Long id, @RequestBody @Valid UserRegistrationRequest updateRequest) {
        return voterService.updateVoter(id, updateRequest);
    }
    @SecurityRequirement(name = "bearer auth")
    @DeleteMapping("/voters/{id}")
    public void deleteVoter (@PathVariable long id) {
        voterService.deleteVoter(id);
    }
}

