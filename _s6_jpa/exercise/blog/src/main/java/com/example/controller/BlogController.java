package com.example.controller;

import com.example.model.BlogModel;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public String listBlog(Model model) {
        List<BlogModel> blogModels = blogService.listBlog();
        model.addAttribute("listBlog", blogModels);
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("createModel", new BlogModel());
        return "/create";
    }

    @PostMapping("/create")
    public String createBlog(int idBlog, String titleBlog, String contentBlog) {
        blogService.create(idBlog, titleBlog, contentBlog);
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

    @GetMapping("{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("formEdit", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editBlog(BlogModel blogModel) {
        blogService.update(blogModel);
        return "redirect:/list";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
