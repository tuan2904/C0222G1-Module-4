//package com.example.blogupdate.controller;
//
//import com.example.blogupdate.model.BlogModel;
//import com.example.blogupdate.service.IBlogService;
//import com.example.blogupdate.util.WebUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.security.Principal;
//
//@Controller
//public class MainController {
//    @Autowired
//    private IBlogService blogService;
//@RequestMapping("")
//public String login() {
//    return "_menu";
//}
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "loginPage";
//    }
//
//    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//        model.addAttribute("title", "Logout");
//        return "logoutSuccessfulPage";
//    }
//    @RequestMapping(value = "/creates", method = RequestMethod.GET)
//    public String create(Model model) {
//        model.addAttribute("title", "Create");
//        return "create";
//    }
//
//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public String userInfo(Model model, Principal principal) {
//
//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "_menu";
//    }
//
//}