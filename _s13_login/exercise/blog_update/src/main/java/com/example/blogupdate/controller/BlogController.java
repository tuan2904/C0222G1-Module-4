package com.example.blogupdate.controller;


import com.example.blogupdate.model.BlogModel;
import com.example.blogupdate.service.IBlogService;
import com.example.blogupdate.service.ICategoryService;
import com.example.blogupdate.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("")
    public String login() {
        return "_menu";
    }

    @GetMapping("/list")
    public String listBlog(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("date_blog").ascending();
        Page<BlogModel> blogModels = blogService.listBlog(PageRequest.of(page, 2, sort));
        model.addAttribute("listBlog", blogModels);
        return "list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String formCreate(Model model) {
        model.addAttribute("createModel", new BlogModel());
        model.addAttribute("listCategory", categoryService.listAll());
        return "/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBlog(BlogModel blogModel) {
        blogService.create(blogModel);
        return "redirect:/list";
    }

    @GetMapping("{idBlog}/delete")
    public String deleteBlog(@PathVariable("idBlog") int idBlog) {
        blogService.remove(idBlog);
        return "redirect:/list";
    }

    @GetMapping("{idBlog}/content")
    public String listContent(@PathVariable("idBlog") int idBlog, Model model) {
        List<BlogModel> list = blogService.listContent(idBlog);
        model.addAttribute("list", list);
        return "/content";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("formEdit", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editBlog(BlogModel blogModel) {
        blogService.update(blogModel);
        return "redirect:/list";
    }

    @GetMapping("/{id}/view")
    public String read(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);

        return "_menu";
    }


}
