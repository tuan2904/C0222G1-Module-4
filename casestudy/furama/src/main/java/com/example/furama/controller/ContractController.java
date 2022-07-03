package com.example.furama.controller;

import com.example.furama.model.Contract;
import com.example.furama.service.contract.IContractService;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IServiceService serviceService;

    @GetMapping("contract/list")
    public String listContract(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        model.addAttribute("listContract", contractService.listContract(PageRequest.of(page, 2)));
        return "contract/list";
    }

    @GetMapping("/contract/create")
    public String formCreate(Model model) {
        model.addAttribute("formCreate", new Contract());
        model.addAttribute("listCustomer", customerService.list());
        model.addAttribute("listService", serviceService.list());
        model.addAttribute("listEmployee", employeeService.list());
        return "/contract/create";
    }

    @PostMapping("/contract/create")
    public String create(@ModelAttribute("formCreate") Contract contract) {
        contractService.create(contract);
        return "redirect:/contract/list";
    }
}
