package com.example.blog.service;


import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> listAll() {

        return categoryRepository.findAll();
    }

    @Override
    public List<Category> listAllCategory(String name) {
        return categoryRepository.selectCategory(name);
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    public void remove(int idCategory) {
        categoryRepository.deleteCategory(idCategory);
    }
}
