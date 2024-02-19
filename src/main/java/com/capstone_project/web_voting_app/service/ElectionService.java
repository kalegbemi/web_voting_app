package com.capstone_project.web_voting_app.service;

import com.capstone_project.web_voting_app.dto.ElectionRequest;
import com.capstone_project.web_voting_app.dto.HttpResponse;
import com.capstone_project.web_voting_app.enom.Status;
import com.capstone_project.web_voting_app.exception.ElectionNotFoundException;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.repository.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ElectionService {

    private final ElectionRepository electionRepo;

    public ResponseEntity<String> findElectionById(Long id) {
        Election election = electionRepo.findById(id).orElseThrow(
                ()->new ElectionNotFoundException("There is no record of election with this id."));

        return ResponseEntity.ok("Election created successfully\n"+election.getTitle());
    }

    public ResponseEntity<List<Election>> findElectionByStatus(Status status) {
        List<Election> election = electionRepo.findByStatus(status);
        return ResponseEntity.ok(election);
    }

    public ResponseEntity<Election> findElectionByTitle(String title) {
        Election election = electionRepo.findByTitle(title);
        return ResponseEntity.ok(election);
    }

    public ResponseEntity<List<Election>> findAllElection() {
        return ResponseEntity.ok(electionRepo.findAll());
    }

    public ResponseEntity<Election> updateElectionById(Long id, ElectionRequest request) {
        Election election2Update = electionRepo.findById(id).orElseThrow(
                ElectionNotFoundException::new);
        election2Update.setTitle(request.getTitle());
        election2Update.setStartDate(request.getStartDate());
        election2Update.setEndDate(request.getEndDate());

        return ResponseEntity.ok(electionRepo.save(election2Update));

    }

    public ResponseEntity<Election> createElection(ElectionRequest request) {
        Election election = new Election();

        election.setTitle(request.getTitle());
        election.setStartDate(request.getStartDate());
        election.setEndDate(request.getEndDate());

        electionRepo.save(election);

        return new ResponseEntity<>(election, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<HttpResponse> deleteElectionById(Long id) throws URISyntaxException {
        if (!electionRepo.existsById(id)){
            throw new ElectionNotFoundException("Election not found");
        }

        URI uri = new URI("votemanagement",
                "http",
                "localhost",
                8080,
                "/election/deleteelectionbyid",
                "id",
                "");
        electionRepo.deleteById(id);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK.name())
                        .requestMethod("getMapping")
                        .path(uri.getPath())
                        .statusCode(HttpStatus.OK.value())
                        .message("Election with ID "+id+", has been successfully deleted")
                        .build()
        );
    }
}
