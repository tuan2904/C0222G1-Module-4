package com.example.furama.controller;

import com.example.furama.model.Service;
import com.example.furama.service.renttype.IRentTypeService;
import com.example.furama.service.service.IServiceService;
import com.example.furama.service.servicetype.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ServiceController {
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IServiceTypeService serviceTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("service/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        model.addAttribute("listService", serviceService.listService(PageRequest.of(page, 2)));
        return "service/list";
    }

    @GetMapping("/service/create")
    public String formCreate(Model model) {
        model.addAttribute("listCreate", new Service());
        model.addAttribute("listServiceType", serviceTypeService.listServiceType());
        model.addAttribute("listRentType", rentTypeService.listRent());
        return "/service/create";
    }

    @PostMapping("/service/create")
    public String createCustomer(@ModelAttribute("listCreate") Service service) {
        serviceService.create(service);
        return "redirect:/service/list";
    }

    @GetMapping("/{id}/service/edit")
    public String formEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("formEdit", serviceService.findById(id));
        model.addAttribute("listServiceType", serviceTypeService.listServiceType());
        model.addAttribute("listRentType", rentTypeService.listRent());
        return "/service/edit";
    }

    @PostMapping("/service/edit")
    public String edit(Service service) {
        serviceService.update(service);
        return "redirect:/service/list";
    }

    @GetMapping("/{id}/service/delete")
    public String remove(@PathVariable("id") int id) {
        serviceService.remove(id);
        return "redirect:/service/list";
    }

    @GetMapping("service/search")
    public String search(@RequestParam(value = "page", defaultValue = "0") int page, Model model, Service service) {
        model.addAttribute("listService", serviceService.search(service, PageRequest.of(page, 2)));
        return "/service/list";
    }
}
