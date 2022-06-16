package com.example.service;

import com.example.model.EmailModel;

import java.util.List;

public interface IEmailService  {
     List<EmailModel> edit(EmailModel emailModel);
     List<EmailModel> create(EmailModel emailModel);
}
