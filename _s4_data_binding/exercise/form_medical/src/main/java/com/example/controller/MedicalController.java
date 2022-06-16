package com.example.controller;

import com.example.model.MedicalModel;
import com.example.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class    MedicalController {
    @Autowired
    private IMedicalService medicalService;
    @GetMapping("/formmedical")
    public String formMedical(Model model){
String[] travelInformation=new String[]{"Tàu","tàu thuyền","ô tô","khác(ghi rõ)"};
model.addAttribute("travelInformation",travelInformation);
String[] birthDay=new String[]{"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
model.addAttribute("birthDay",birthDay);
        model.addAttribute("medicalModel",new MedicalModel());
        return "formmedical";
    }

    @PostMapping("/formmedical")
    public String listMedical(@ModelAttribute("medicalList") MedicalModel medicalModel,Model model){
        model.addAttribute("medical",medicalService.listMedical(medicalModel));
        return "index";
    }
}
