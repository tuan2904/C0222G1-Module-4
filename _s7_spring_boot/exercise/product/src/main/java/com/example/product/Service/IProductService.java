package com.example.product.Service;

import com.example.product.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(Product product);

    Page<Product> findAllProductByName(Pageable pageable, Product product);

}
