package com.example.restfulblog.controller.rest;

import com.example.restfulblog.model.BlogModel;
import com.example.restfulblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<BlogModel>> findAllBlog(@RequestParam(value = "page", defaultValue = "0") int page) {
        Page<BlogModel> blogModels = blogService.listBlog(PageRequest.of(page, 2));
        if (blogModels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogModels, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<BlogModel>> findBlogById(@RequestParam(value = "page", defaultValue = "0") int page,@PathVariable("id") int id) {
        Page<BlogModel> blogModels = blogService.findByIdBlog(id, PageRequest.of(page, 2));
        if (blogModels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogModels, HttpStatus.OK);
    }

}
