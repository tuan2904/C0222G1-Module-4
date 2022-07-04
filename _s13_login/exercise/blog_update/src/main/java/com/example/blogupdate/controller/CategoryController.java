package com.example.blogupdate.controller;


import com.example.blogupdate.model.Category;
import com.example.blogupdate.service.CategoryService;
import com.example.blogupdate.service.IBlogService;
import com.example.blogupdate.service.ICategoryService;
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
