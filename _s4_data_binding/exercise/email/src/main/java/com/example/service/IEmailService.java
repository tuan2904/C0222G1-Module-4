package com.example.service;

import com.example.model.EmailModel;

import java.util.List;

public interface IEmailService  {
    public List<EmailModel> edit(EmailModel emailModel);
    public List<EmailModel> create(EmailModel emailModel);
}
