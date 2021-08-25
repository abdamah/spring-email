package com.riigsoft.springemail.service.impl;

import com.riigsoft.springemail.model.EmailSender;
import com.riigsoft.springemail.service.IEmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

/***
 * @author Abdallah
 * Spring mail used to send email to target mail ids or clients.
 * This service uses two @methods SimpleText and TextWithAttachment.
 */
@Service
public class EmailSenderServiceImpl implements IEmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(EmailSender emailSender) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("spring.mail@gmail.com");
        message.setTo(emailSender.getTo());
        message.setText(emailSender.getText());
        message.setSubject(emailSender.getSubject());

        mailSender.send(message);
        System.out.println("Mail has been sent successfully...");
    }

    public void sendSimpleMessageWithAttachment(EmailSender emailSender) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("spring.mail@gmail.com");
        mimeMessageHelper.setTo(emailSender.getTo());
        mimeMessageHelper.setText(emailSender.getText());
        mimeMessageHelper.setSubject(emailSender.getSubject());

        FileSystemResource fileSystem
                = new FileSystemResource(new File(emailSender.getAttachment()));

        mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystem.getFilename()),
                fileSystem);

        mailSender.send(mimeMessage);
        System.out.println("Mail has been sent successfully...");

    }
}