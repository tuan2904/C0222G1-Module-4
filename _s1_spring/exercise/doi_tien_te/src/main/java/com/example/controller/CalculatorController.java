package com.example.controller;

import com.example.service.CalculatorService;
import com.example.service.ICalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    ICalculatorService calculatorService = new CalculatorService();
//khi enter trên url or thẻ a mặc đinh là get
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/index")
    public String submit(@RequestParam Double input, Model model) {
        model.addAttribute("input", input);
        model.addAttribute("result1", calculatorService.calculator(input));
        return "index";
    }
}
