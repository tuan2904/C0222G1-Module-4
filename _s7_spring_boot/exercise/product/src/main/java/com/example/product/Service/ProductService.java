package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> listProduct(Pageable pageable) {
        return productRepository.lisProduct(pageable);
    }

    @Override
    public void remove(int id) {
        productRepository.deleteBlog(id);
    }

    @Override
    public void update(Product product) {
        productRepository.editProduct(product.getIdProduct(), product.getNameProduct(), product.getPriceProduct(),
                product.getDescribeProduct(), product.getProducerProduct());
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> search(String name,Pageable pageable) {
        return productRepository.searchBlog(name,pageable);
    }

    @Override
    public Product searchId(int id) {
        return productRepository.findAllByIdProduct(id);
    }
}
