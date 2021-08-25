package com.riigsoft.springemail.service;

import com.riigsoft.springemail.model.EmailSender;

import javax.mail.MessagingException;
/* @author Abdallah
 * Spring mail used to send email to target mail ids or clients.
 * This service uses two @methods SimpleText and TextWithAttachment.
 * @throws MessagingException
 * @return type void.
 */
public interface IEmailSenderService {

    void sendSimpleMessage(EmailSender emailSender);

    void sendSimpleMessageWithAttachment(EmailSender emailSender) throws MessagingException;

}