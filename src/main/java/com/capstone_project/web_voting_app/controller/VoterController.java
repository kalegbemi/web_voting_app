package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.dto.UserRegistrationRequest;
import com.capstone_project.web_voting_app.model.Voter;
import com.capstone_project.web_voting_app.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voter")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/save")
    public Voter createVoter (@RequestBody UserRegistrationRequest request) {
        return voterService.saveVoter(request);
    }
    @PostMapping("/authenticate")
    public boolean authenticateVoter(@RequestParam String username, @RequestParam String password) {
        return voterService.authenticateVoter(username, password);
    }
    @GetMapping("/allvoters")
    public List<Voter> getAllVoters() {

        return voterService.getAllVoters();
    }

    @GetMapping("/voters/{id}")
    public Voter getVoterById(@PathVariable long id){

        return voterService.getVoterById(id).orElse(null);
    }

    @PutMapping("/voters/{id}")
    public String updateVoter(@PathVariable long id, @RequestBody UserRegistrationRequest updateRequest) {
        return voterService.updateVoter(id, updateRequest);
    }

    @DeleteMapping("/voters/{id}")
    public void deleteVoter (@PathVariable long id) {
        voterService.deleteVoter(id);
    }
}

