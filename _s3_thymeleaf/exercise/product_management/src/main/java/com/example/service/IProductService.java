package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProduct();

    void remove(int id);

    void update(Product product);

    void create(Product product);

        List<Product> search(String name);

        Product searchId(int id);
}
