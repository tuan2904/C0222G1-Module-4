package com.example.furama.controller;

import com.example.furama.model.Employee;
import com.example.furama.service.division.IDivisionService;
import com.example.furama.service.educationdegree.IEducationDegreeService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.position.IPositionService;
import com.example.furama.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;

    @GetMapping("/employee/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        model.addAttribute("listEmployee", employeeService.listEmployee(PageRequest.of(page, 2)));
        return "/employee/list";
    }

    @GetMapping("/employee/create")
    public String formCreate(Model model) {
        model.addAttribute("listEmployee", new Employee());
        model.addAttribute("listUser",userService.listUser());
        model.addAttribute("listDivision",divisionService.listDivision());
        model.addAttribute("listEducation", educationDegreeService.listEducation());
        model.addAttribute("listPosition", positionService.listPosition());
        return "/employee/create";
    }
    @PostMapping("/employee/create")
    public String createEmployee(@ModelAttribute("listEmployee") Employee employee){
        employeeService.create(employee);
        return "redirect:/employee/list";
    }
}
