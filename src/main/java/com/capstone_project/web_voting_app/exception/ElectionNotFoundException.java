package com.capstone_project.web_voting_app.exception;

public class ElectionNotFoundException extends RuntimeException{
    public ElectionNotFoundException(String message) {
        super(message);
    }

    public ElectionNotFoundException() {
    }

    @Override
    public String toString() {
        return "ElectionNotFoundException{}";
    }
}
