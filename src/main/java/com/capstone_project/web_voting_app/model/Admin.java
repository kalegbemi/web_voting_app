package com.capstone_project.web_voting_app.model;

import com.capstone_project.web_voting_app.enom.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
    public class Admin implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int Id;

        private String password;

        private String fullName;

        private String email;

        @Enumerated(value = EnumType.STRING)
        private Role role = Role.ADMIN;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority(role.name()));
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
}
