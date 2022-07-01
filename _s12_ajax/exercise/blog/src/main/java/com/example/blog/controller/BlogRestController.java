package com.example.blog.controller;

import com.example.blog.model.BlogModel;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/load/{id}")
    public ResponseEntity<Iterable<BlogModel>> load(@PathVariable("id") int id, @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<BlogModel> listLoad = blogService.listBlog(PageRequest.of(page, id));
        return new ResponseEntity<>(listLoad, HttpStatus.OK);
    }

    @GetMapping("/search/{titleBlog}")
    public ResponseEntity<Iterable<BlogModel>> searchBlog(@RequestParam(name = "page", defaultValue = "0") int page, @PathVariable String titleBlog) {
        Page<BlogModel> page1 = blogService.searchName(titleBlog, PageRequest.of(page, 2));
        return new ResponseEntity<>(page1, HttpStatus.OK);
    }
}
