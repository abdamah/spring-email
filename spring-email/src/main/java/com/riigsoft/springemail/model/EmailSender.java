package com.riigsoft.springemail.model;

import lombok.Data;

@Data
public class EmailSender {
    private String to;
    private String text;
    private String subject;
    private String attachment;
}

