package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.dto.AdminRegisterRequest;
import com.capstone_project.web_voting_app.dto.AdminUpdateRequest;
import com.capstone_project.web_voting_app.dto.AuthenticationRequest;
import com.capstone_project.web_voting_app.dto.AuthenticationResponse;
import com.capstone_project.web_voting_app.model.Admin;
import com.capstone_project.web_voting_app.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("api/v1/admin")
    public class AdminController {

    @Autowired
    public AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> register(@Valid @RequestBody AdminRegisterRequest request) {
        return new ResponseEntity<>(adminService.register(request), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return adminService.authenticate(request);
    }

    @GetMapping("/allAdmins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody AdminUpdateRequest adminUpdateRequest) {
        return adminService.updateAdmin(id,adminUpdateRequest);
    }
    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }
}


