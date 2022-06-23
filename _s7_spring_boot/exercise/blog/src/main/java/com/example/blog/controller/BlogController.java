package com.example.blog.controller;

import com.example.blog.model.BlogModel;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String listBlog(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("date_blog").ascending();
        Page<BlogModel> blogModels = blogService.listBlog(PageRequest.of(page, 2, sort));
        model.addAttribute("listBlog", blogModels);
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("createModel", new BlogModel());
        model.addAttribute("listCategory", categoryService.listAll());
        return "/create";
    }

    @PostMapping("/create")
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

    @GetMapping("/search")
    public String searchBlog(@RequestParam(name = "page", defaultValue = "0") int page, Model model, BlogModel blogModel) {
        model.addAttribute("list", blogService.search(blogModel, PageRequest.of(page, 1)));
        return "/list";
    }

}
