package com.example.service;

import com.example.model.BlogModel;

import java.util.List;

public interface IBlogService {
    List<BlogModel> listBlog();

    void create(int idBlog, String titleBlog, String contentBlog);

    void remove(int idBlog);

    List<BlogModel> listContent(int idBlog);

    void update(BlogModel blogModel);

    BlogModel findById(int id);
}
