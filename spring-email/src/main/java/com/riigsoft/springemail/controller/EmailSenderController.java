package com.riigsoft.springemail.controller;

import com.riigsoft.springemail.model.EmailSender;
import com.riigsoft.springemail.service.IEmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/***
 * @author Abdallah
 * Spring mail api
 */
@RestController
@RequestMapping("/email")
public class EmailSenderController {

    @Autowired
    private IEmailSenderService service;
    /*
     * @author Abdallah
     *  This calls service and send email to target email id.
     * @method GET fot sending email
     *@return type ResponseEntity<String>
     */
    @GetMapping("/send")
    public ResponseEntity<String> sendEmail() throws MessagingException {
        EmailSender emailSender = new EmailSender();
        emailSender.setTo("test@gmail.com");
        emailSender.setText("This is Email Body with Attachment...");
        emailSender.setSubject("Email with Attachment");
        emailSender.setAttachment("C:\\Users\\abdallah\\Desktop\\realtimeproject.jpg");
        service.sendSimpleMessageWithAttachment(emailSender);

        return ResponseEntity.ok("Mail has been sent successfully...");
    }
}
