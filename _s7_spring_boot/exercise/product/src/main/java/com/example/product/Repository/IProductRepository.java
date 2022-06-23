package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from products", nativeQuery = true)
    Page<Product> lisProduct(Pageable pageable);

    @Query(value = "select * from products where id_product=:id_product", nativeQuery = true)
    Product findAllByIdProduct(@Param("id_product") int id);

    @Modifying
    @Query(value = "delete from products where id_product=:id_product", nativeQuery = true)
    void deleteBlog(@Param("id_product") int idProduct);

    @Query(value = "select * from products where name_product like :name_product", nativeQuery = true)
    Page<Product> searchBlog(@Param("name_product") String name, Pageable pageable);

    @Modifying
    @Query(value = "update products set id_product=:id_product,name_product=:name_product,price_product=:price_product," +
            "describe_product=:describe_product,producer_product=:producer_product where id_product=:id_product",
            nativeQuery = true)
    void editProduct(@Param("id_product") int id, @Param("name_product") String name,
                     @Param("price_product") double price, @Param("describe_product") String describe, @Param("producer_product") String producer);
}
