package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping("/convert")
    public String index() {
        return "index";
    }

    @PostMapping("/usd")
    public String submit(@RequestParam double usd,double vnd, Model model) {
        double result = vnd * usd;
        model.addAttribute("result1", result);
        return "submit";
    }
}
