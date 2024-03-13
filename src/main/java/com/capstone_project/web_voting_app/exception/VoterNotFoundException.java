package com.capstone_project.web_voting_app.exception;

public class VoterNotFoundException extends RuntimeException{

    public VoterNotFoundException(String message) {super(message);}

    @Override
    public String toString() {return "VoterNotFoundException{}";}
}
