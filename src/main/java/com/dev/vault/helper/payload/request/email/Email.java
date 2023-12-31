package com.dev.vault.helper.payload.request.email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String recipient;
    private String body;
}