package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/dictionary")
    public String index() {
        return "index";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String english, Model model) {
        model.addAttribute("english", iDictionaryService.iDictionaryService(english));
            model.addAttribute("language", english);
        return "index";
    }
}
