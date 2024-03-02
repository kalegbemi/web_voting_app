package com.capstone_project.web_voting_app.exception;

public class VoteNotFoundException extends RuntimeException{
    public VoteNotFoundException(String message) {super(message);}

    @Override
    public String toString() {return "VoteNotFoundException{}";}
}
