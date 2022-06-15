package com.example.controller;

import com.example.model.EmailModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Email {
    @GetMapping("/email")
    public String formEmail(Model model){
        model.addAttribute("email",new EmailModel());
        return "email";
    }

    @PostMapping
    public String submit(@ModelAttribute("email") EmailModel emailModel,Model model){

        return null;
    }
}
