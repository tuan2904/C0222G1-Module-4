package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Spice {

    @GetMapping("/save")
    public String save(@RequestParam(name = "condiment",required = false) String[] condiment, Model model, RedirectAttributes redirectAttributes) {
//        model.addAttribute("condiment", condiment);
     //   redirectAttributes.addFlashAttribute("condiment", condiment);
        return "redirect:/save2";
    }

    @GetMapping("/save2")
    public String save2(@RequestParam(name = "condiment",required = false) String[] condiment, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("condiment", condiment);
//        redirectAttributes.addFlashAttribute("condiment", condiment);
        return "save";
    }
}

