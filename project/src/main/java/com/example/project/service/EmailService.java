package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.project.entity.Email;
import com.example.project.repository.EmailRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    
	@Autowired JavaMailSender jms;

    @Autowired EmailRepository emailRepo; 

    public String sendMail(String receiver, String subject, String body) {
        Email email = new Email();
        email.setReceiver(receiver);
        email.setSubject(subject);
        email.setBody(body);
        
        try {
            MimeMessage message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(body);
            
            jms.send(message);
            
            
            emailRepo.save(email);
            
            return "Email Sent Successfully to " + receiver;
        } catch (MessagingException e) {
            
            return "Mail not sent due to: " + e.getMessage();
        }
    }
}
