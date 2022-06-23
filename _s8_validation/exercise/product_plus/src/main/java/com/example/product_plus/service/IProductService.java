package com.example.product_plus.service;

import com.example.product_plus.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> listProduct(Pageable pageable);

    void remove(int id);

    void update(Product product);

    void create(Product product);

    Page<Product> search(String name,Pageable pageable);

    Product searchId(int id);
}
