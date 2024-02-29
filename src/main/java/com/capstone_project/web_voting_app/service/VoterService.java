package com.capstone_project.web_voting_app.service;

import com.capstone_project.web_voting_app.dto.UserRegistrationRequest;
import com.capstone_project.web_voting_app.enom.Role;
import com.capstone_project.web_voting_app.model.Voter;
import com.capstone_project.web_voting_app.repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoterService {

    private final VoterRepository voterRepository;
    private final EmailService emailService;

    @CacheEvict(value = "allVoter", allEntries = true)
    public Voter saveVoter(UserRegistrationRequest request) {
        Voter voter = new Voter();
        voter.setFirstName(request.getFirstName());
        voter.setLastName(request.getLastName());
        voter.setPassword(request.getPassword());
        voter.setEmail(request.getEmail());
        voter.setDOB(request.getDOB());
        int age = (LocalDate.now().getYear() - request.getDOB().getYear());
        if( age >= 18 && age <= 70 ){
            voter.setEligible(true);
        }
        else
        {
            voter.setEligible(false);
        }
        voter.setRole(Role.VOTER);
        voterRepository.save(voter);
        String name = voter.getFirstName() + " " + voter.getLastName();
        emailService.sendVoterMessage(voter.getEmail(),name, voter.getRole().name());
        //emailService.sendMessage(voter.getEmail(),name, voter.getRole().name());
        return voter;
    }


    @Cacheable(value = "allVoters")
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }
    @Cacheable(value = "singleVoter")
    public Optional<Voter> getVoterById(Long voterId) {

        return voterRepository.findById(voterId);
    }
    @CacheEvict(value = "singleVoter", allEntries = true)
    public void deleteVoter(long voterId) {
        voterRepository.deleteById(voterId);
    }

    @CacheEvict(value = "singleVoter", allEntries = true)
    public String updateVoter(long id, UserRegistrationRequest request) {
        Optional<Voter> optionalVoter = voterRepository.findById(id);

        if (optionalVoter.isPresent()) {
            Voter toUpdate = optionalVoter.get();

            toUpdate.setPassword(request.getPassword());
            toUpdate.setFirstName(request.getFirstName());
            toUpdate.setEmail(request.getEmail());
            toUpdate.setLastName(request.getLastName());
            toUpdate.setDOB(request.getDOB());
            int age = (LocalDate.now().getYear() - request.getDOB().getYear());
            if( age >= 18 && age <= 70 ){
                toUpdate.setEligible(toUpdate.isEligible());
            }
            else
            {
                toUpdate.setEligible(false);
            }

            voterRepository.save(toUpdate);

            return "User successfully updated";
        } else {

            return "User not found with ID: " + id;
        }
    }
}

