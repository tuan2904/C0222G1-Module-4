package com.example.restfulblog.service;


import com.example.restfulblog.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ICategoryService {
    void create(Category category);

    List<Category> listAll();

    List<Category> listAllCategory(String name);
}
