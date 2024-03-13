package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.dto.ElectionPageableResponse;
import com.capstone_project.web_voting_app.dto.ElectionRequest;
import com.capstone_project.web_voting_app.dto.HttpResponse;
import com.capstone_project.web_voting_app.enom.Status;
import com.capstone_project.web_voting_app.model.Election;
import com.capstone_project.web_voting_app.service.ElectionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/election")
@SecurityRequirement(name = "bearer auth")
public class ElectionController {


    private final ElectionService electionService;

    /*    public ResponseEntity<ElectionPageableResponse> getAllElections(
        public ModelAndView getAllElections(
                @RequestParam( value = "pageNo",defaultValue = "0",required = false) int pageNo,
                @RequestParam(value = "pageSize", defaultValue = "5",required = false) int pageSize
        )*/
    @GetMapping("/all")
    public ModelAndView getAllElections() {
        ModelAndView modelAndView = new ModelAndView("All-elections");
        List<Election> electionList = electionService.findAllElection();
        modelAndView.addObject("elections", electionList);
        return modelAndView;
    }

    @GetMapping("/getById")
    public ResponseEntity<String> findById(@RequestParam("id") Long id) {
        return electionService.findElectionById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Election> saveElection(@Valid @RequestBody ElectionRequest request) {

        return electionService.createElection(request);
    }

    @GetMapping("/getByStatus")
    public ResponseEntity<List<Election>> findElectionByStatus(@RequestParam("status") Status status) {
        return electionService.findElectionByStatus(status);
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<Election> findElectionByTitle(@RequestParam("title") String title) {
        return electionService.findElectionByTitle(title);
    }

    @PutMapping("/updateElection/{id}")
    public ResponseEntity<Election> updateElectionById(@PathVariable Long id, @Valid @RequestBody ElectionRequest request) {

        return electionService.updateElectionById(id, request);
    }

    @DeleteMapping("/deleteelectionbyid/{id}")
    public ResponseEntity<HttpResponse> deleteElectionById(@PathVariable Long id) {
        return electionService.deleteElectionById(id);
    }
}
