package com.example.music.controller;


import com.example.music.model.MusicModel;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicCustomer {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/list")
    public String listMusic(Model model) {
        List<MusicModel> productModel = musicService.listMusic();
        model.addAttribute("listMusic", productModel);
        return "/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("formCreate", new MusicModel());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("formCreate") MusicModel musicModel, BindingResult bindingResult) {
        new MusicModel().validate(musicModel, bindingResult);
        if (bindingResult.hasErrors()) {
            return ("/create");
        }
        musicService.save(musicModel);
        return "redirect:/list";
    }

    @GetMapping("{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("formEdit", musicService.searchId(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("formEdit") MusicModel musicModel) {
        musicService.update(musicModel);
        return "redirect:/list";
    }

    @GetMapping("{id}/delete")
    public String view(@PathVariable("id") int id) {
        musicService.remove(id);
        return "redirect:/list";
    }
}
