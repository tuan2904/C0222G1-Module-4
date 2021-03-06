package com.example.controller;

import com.example.model.EmailModel;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/email")
    public String formEmail(Model model) {
        model.addAttribute("emailModel", new EmailModel());
        String[] language = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        model.addAttribute("language", language);
        String[] pageSize = new String[]{"5", "10", "15", "25", "50", "100"};
        String[] spamsFilter = new String[]{"Enable spams filter"};
        model.addAttribute("spamsFilter", spamsFilter);
        model.addAttribute("pageSizes", pageSize);
        return "email";
    }

    @GetMapping("/edit")
    public String formEdit(Model model) {
        model.addAttribute("emailModel", new EmailModel());
        return "edit";
    }

    @PostMapping("/email")
    public String submit(@ModelAttribute("email") EmailModel emailModel, Model model) {
        model.addAttribute("emailModel", emailService.create(emailModel));
        return "index";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute EmailModel emailModel, Model model) {
        model.addAttribute("emailEdit", emailService.edit(emailModel));
        return "index";
    }
}
