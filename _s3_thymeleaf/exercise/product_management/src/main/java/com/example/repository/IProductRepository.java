package com.example.repository;

import com.example.model.ProductModel;

import java.util.List;

public interface IProductRepository {
    List<ProductModel> listProduct();

    void remove(int id);

    void update(ProductModel productModel);

    void create(ProductModel productModel);

    List<ProductModel> search(String name);

    ProductModel searchId(int id);
}
