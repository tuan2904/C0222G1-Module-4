package com.example.products.Service;

import com.example.products.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    Page<Product> findAllProductByName(Pageable pageable, String nameProduct);

}
