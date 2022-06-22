package com.example.products.Service;


import com.example.products.Model.Product;
import com.example.products.Repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAllProduct(pageable);
    }

    @Override
    public Page<Product> findAllProductByName(Pageable pageable, String nameProduct) {
        return productRepository.findAllProductByName(pageable, nameProduct);
    }

    @Override
    public void remove(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findByIdProduct(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product.getNameProduct(), product.getPrice(), product.getDescription(), product.getProducer(), product.getIdProduct());

    }

    @Override
    public void save(Product product) {
        productRepository.save(product.getNameProduct(), product.getPrice(), product.getDescription(), product.getProducer());
    }

}
