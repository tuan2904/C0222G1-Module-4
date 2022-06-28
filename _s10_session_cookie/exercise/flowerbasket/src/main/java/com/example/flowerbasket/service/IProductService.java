package com.example.flowerbasket.service;

import com.example.flowerbasket.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
