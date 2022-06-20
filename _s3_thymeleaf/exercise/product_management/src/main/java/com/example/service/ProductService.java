package com.example.service;

import com.example.model.ProductModel;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<ProductModel> listProduct() {
        return productRepository.listProduct();
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public void update(ProductModel productModel) {
        productRepository.update(productModel);
    }

    @Override
    public void create(ProductModel productModel) {
        productRepository.create(productModel);
    }

    @Override
    public List<ProductModel> search(String nameProduct) {
        return productRepository.search(nameProduct);
    }

    @Override
    public ProductModel searchId(int id) {
        return productRepository.searchId(id);
    }
}
