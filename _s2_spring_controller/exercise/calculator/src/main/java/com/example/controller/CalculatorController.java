package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam Double number1, @RequestParam Double number2, String total, Model model) {
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", calculatorService.calculator(number1, number2, total));
        return "calculator";
    }

}
