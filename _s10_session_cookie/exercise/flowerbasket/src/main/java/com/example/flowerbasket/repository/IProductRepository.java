package com.example.flowerbasket.repository;

import com.example.flowerbasket.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository  extends PagingAndSortingRepository<Product, Long> {
}
