package com.mardeveloper.email.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mardeveloper.email.enitities.Email;
import com.mardeveloper.email.enums.StatusEmail;
import com.mardeveloper.email.repositories.EmailRepository;

@Service
public class EmailService {
	
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @SuppressWarnings("finally")
	public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);            
            return email;
        } catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
            return email;
        } finally {
            return emailRepository.save(email);
        }
    }

    public Page<Email> findAll(Pageable pageable) {
        return  emailRepository.findAll(pageable);
    }

    public Optional<Email> findById(Long emailId) {
        return emailRepository.findById(emailId);
    }	

}
