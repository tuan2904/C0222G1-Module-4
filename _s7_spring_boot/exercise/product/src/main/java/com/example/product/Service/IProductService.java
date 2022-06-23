package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> listProduct(Pageable pageable);

    void remove(int id);

    void update(Product product);

    void create(Product product);

    Page<Product> search(String name,Pageable pageable);

    Product searchId(int id);
}
