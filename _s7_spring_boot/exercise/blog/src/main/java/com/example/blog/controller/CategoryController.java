package com.example.blog.controller;


import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private CategoryService categoryServices;

    @GetMapping("/listCategory")
    public String listCategory(Model model ){
        List<Category> listCategory=categoryService.listAll();
        model.addAttribute("listCategory",listCategory);
        return ("/listCategory");
    }
}
