package com.example.formregister.controller;

import com.example.formregister.model.Register;
import com.example.formregister.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private IRegisterService registerService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list",registerService.listRegister());
        return "/list";
    }
    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("formCreate", new Register());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("formCreate") Register register, BindingResult bindingResult) {
        new Register().validate(register, bindingResult);
        if (bindingResult.hasErrors()) {
            return ("/create");
        }
        registerService.save(register);
        return "redirect:/list";
    }
}
