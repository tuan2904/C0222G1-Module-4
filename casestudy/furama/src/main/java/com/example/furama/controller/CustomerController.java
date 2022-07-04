package com.example.furama.controller;

import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;
import com.example.furama.service.ICustomerTypeService;
import com.example.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("listCustomerType")
    public String listCustomerType() {
        customerTypeService.listCustomerType();
        return "";
    }

    @GetMapping("/customer/list")
    public String listCustomer(@ModelAttribute("listCreate") Customer customer, Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
       model.addAttribute("formEdit",new Customer());
        model.addAttribute("listCustomer", customerService.listCustomer(PageRequest.of(page, 2)));
        model.addAttribute("listCustomerType", customerTypeService.listCustomerType());
        return "/customer/list";
    }

    @GetMapping("/customer/create")
    public String formCreate(Model model) {
        model.addAttribute("listCreate", new Customer());
        return "/customer/create";
    }


    @PostMapping("/customer/create")
    public String createCustomer(@ModelAttribute("listCreate") Customer customer) {
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/customer/delete")
    public String remove(@PathVariable("id") int id) {
        customerService.remove(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/customer/edit")
    public String formEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("formEdit", customerService.findById(id));
        model.addAttribute("listCustomerType", customerTypeService.listCustomerType());
        return "/customer/edit";
    }

    @PostMapping("/customer/edit")
    public String edit(@ModelAttribute("formEdit") Customer customer) {
        customerService.update(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/search")
    public String search(@RequestParam(value = "page", defaultValue = "0") int page, Model model, Customer customer) {
        model.addAttribute("listCustomer", customerService.search(customer, PageRequest.of(page, 2)));
        return "/customer/list";
    }
}
