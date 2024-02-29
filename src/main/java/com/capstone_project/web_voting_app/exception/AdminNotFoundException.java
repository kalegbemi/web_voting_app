package com.capstone_project.web_voting_app.exception;

    public class AdminNotFoundException extends RuntimeException{
        public AdminNotFoundException(String message) {
            super(message);
        }

        @Override
        public String toString() {
            return "AdminNotFoundException: ";
        }
    }
