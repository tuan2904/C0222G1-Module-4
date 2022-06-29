package com.example.restfulblog.service;

import com.example.restfulblog.model.BlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {
    Page<BlogModel> search(BlogModel blogModel, Pageable pageable);

    Page<BlogModel> listBlog(Pageable pageable);

    void create(BlogModel blogModel);

    void remove(int idBlog);

    List<BlogModel> listContent(int idBlog);

    void update(BlogModel blogModel);

    BlogModel findById(int id);

    Page<BlogModel> findByIdBlog(int id,Pageable pageable);

}

