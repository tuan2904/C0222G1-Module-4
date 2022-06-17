package com.example.service;

import com.example.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> listProduct();

    void remove(int id);

    void update(int id, ProductModel productModel);

    void create(ProductModel productModel);

    List<ProductModel> search(String name);

    ProductModel searchId(int id);
}
