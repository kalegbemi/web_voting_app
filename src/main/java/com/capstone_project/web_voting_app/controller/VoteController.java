package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.dto.VoteRequest;
import com.capstone_project.web_voting_app.model.Vote;
import com.capstone_project.web_voting_app.service.VoteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@SecurityRequirement(name = "bearer auth")
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/castVote")
    public ResponseEntity<String> castVote(@RequestBody VoteRequest voteRequest) {
        return voteService.castVote(voteRequest);
    }

    @GetMapping("/election/{electionId}")
    public ResponseEntity<Vote> getElectionById(@PathVariable("electionId") long id) {
        return voteService.getElectionById(id);

    }

    @GetMapping("/voter/{voterId}")
    public ResponseEntity<Vote> getVoteByVoterId(@PathVariable("voterId") long id) {
        return voteService.getVoteByVoterId(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vote>> findAllVote() {
        return voteService.findAllVote();
    }


}
