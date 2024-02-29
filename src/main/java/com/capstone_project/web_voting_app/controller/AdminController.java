package com.capstone_project.web_voting_app.controller;

import com.capstone_project.web_voting_app.dto.AdminRegisterRequest;
import com.capstone_project.web_voting_app.dto.AdminUpdateRequest;
import com.capstone_project.web_voting_app.dto.AuthenticationRequest;
import com.capstone_project.web_voting_app.dto.AuthenticationResponse;
import com.capstone_project.web_voting_app.model.Admin;
import com.capstone_project.web_voting_app.service.AdminService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @SecurityRequirement(name = "bearer auth")
    @PostMapping("/register")
    public ResponseEntity<Admin> register(@Valid @RequestBody AdminRegisterRequest request) {
        return new ResponseEntity<>(adminService.register(request), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody @Valid AuthenticationRequest request) throws Throwable {
        return adminService.authenticate(request);
    }

    @SecurityRequirement(name = "bearer auth")
    @GetMapping("/allAdmins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @SecurityRequirement(name = "bearer auth")
    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    @SecurityRequirement(name = "bearer auth")
    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable int id, @Valid @RequestBody AdminUpdateRequest adminUpdateRequest) {
        return adminService.updateAdmin(id,adminUpdateRequest);
    }
    @SecurityRequirement(name = "bearer auth")
    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }
}


