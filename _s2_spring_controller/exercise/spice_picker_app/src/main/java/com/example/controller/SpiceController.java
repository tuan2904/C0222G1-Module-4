package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
    @GetMapping("/save")
    public String save(@RequestParam(name = "condiment", required = false) String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "save";
    }

    @PostMapping("/save")
    public String save2(@RequestParam(name = "condiment", required = true) String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "save";
    }
}

