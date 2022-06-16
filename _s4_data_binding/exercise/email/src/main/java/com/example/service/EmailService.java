package com.example.service;

import com.example.model.EmailModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    private static List<EmailModel> emailModels = new ArrayList<>();

    @Override
    public List<EmailModel> edit(EmailModel emailModel) {
        emailModel.setLanguage(emailModel.getLanguage());
        emailModel.setPageSize(emailModel.getPageSize());
        emailModel.setSpamsFilter(emailModel.getSpamsFilter());
        emailModel.setSignature(emailModel.getSignature());
        emailModels.add(emailModel);
        return emailModels;
    }

    @Override
    public List<EmailModel> create(EmailModel emailModel) {
        emailModels.add(emailModel);
        return emailModels;
    }
}
