package com.capstone_project.web_voting_app.service;


import com.capstone_project.web_voting_app.dto.CandidateEmailDetails;
import com.capstone_project.web_voting_app.util.MessageUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class EmailService {
    public static final String SUBJECT = "WELCOME ONBOARD";
    private static final String NOTIFICATION_REMINDER = "ELECTION NOTIFICATION / REMINDER";

    private final String From = "kydjams@gmail.com";
    private static final String UTF_8_ENCODING = "UTF-8";


    @Autowired
    private JavaMailSender mailSender;

    public void sendVoterMessage(String email, String name, String role) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(From);
            message.setTo(email);
            message.setSubject(SUBJECT);
            message.setText(MessageUtil.getVoterMessage(name, role));
            mailSender.send(message);
            String messageString = message.toString();
            System.out.println(messageString);

        } catch (MailException E) {
            throw new RuntimeException(E.getMessage() + "\n\nEMAIL SENDING FAILED");

        }

    }

    public void sendMessage(String to, String body, String sbj) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setPriority(1);
            helper.setText(body);
            helper.setTo(to);
            helper.setFrom(From);
            helper.setSubject(sbj);
            mailSender.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    public void sendCandidateMessage(CandidateEmailDetails details) {
        log.info("sending email to candidate {}", details.getName());
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, UTF_8_ENCODING);
            helper.setFrom(From);
            helper.setTo(details.getTo());
            helper.setSubject(SUBJECT);
            helper.setText(MessageUtil.getCandidateMessage(details));
            mailSender.send(message);


        } catch (MessagingException e) {
            log.error(e.getMessage());
        }

    }

    public void sendMessage24Hrbefore(String to, String name, String electionTitle, LocalDateTime time) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setPriority(1);
            helper.setText(MessageUtil.Message24HrBeforeElection(name, electionTitle, time));
            helper.setTo(to);
            helper.setFrom(From);
            helper.setSubject(NOTIFICATION_REMINDER);
            mailSender.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
