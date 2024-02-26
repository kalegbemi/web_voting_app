package com.capstone_project.web_voting_app.util;

import com.capstone_project.web_voting_app.dto.CandidateEmailDetails;

import java.time.LocalDateTime;

public class MessageUtil {

    public static String getVoterMessage(String name, String role){
        return "Hello "+ name+",\n\nYou have been registered as a "+role+" on the INGRYD VOTING APPLICATION." +
                "\n\nFurther information will be communicated as the needs arises.\n\n\n\nThank you,\n\nSupport team.";
    }

    public static String Message24HrBeforeElection(String name, String electionTitle, LocalDateTime time){
        return "Hello "+ name+",\n\nThis is to inform / remind you that the  "+electionTitle+" election will be taking place tomorrow (" +
                time+"). "+
                "\n\nWe encourage you to let your vote count by participating.\n\n\n\nThank you,\n\nSupport team.";
    }


    public static String getCandidateMessage(CandidateEmailDetails details){
        return "Hello "+ details.getName()+",\n\nYou have been registered as a "+details.getRole()+" on the INGRYD VOTING APPLICATION." +
                "\n\nYou were registered as a candidate contesting for the position of "+details.getPosition() +" under " +
                "the party "+details.getParty()+"."+
                "\n\nFurther information will be communicated as the needs arises.\n\n\n\nThank you,\n\nSupport team.";
    }
}
