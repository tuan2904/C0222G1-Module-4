package com.example.products.Repository;

import com.example.products.Model.Product;
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
public interface IProductRepository  extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product where status_delete = 1", nativeQuery = true)
    Page<Product> findAllProduct(Pageable pageable);

    @Modifying
    @Query(value = "insert into product (name_product, price, description, producer, status_delete) values (:name, :price, :description, :producer, 1)", nativeQuery = true)
    void save(@Param("name") String name, @Param("price") Integer price, @Param("description") String description, @Param("producer") String producer);

    @Query(value = "select * from product where id_product = :id", nativeQuery = true)
    Product findByIdProduct(@Param("id") Integer id);

    @Modifying
    @Query(value = "update product set name_product = :nameProduct, price = :priceProduct, description = :descriptionProduct, producer = :producer where id_product = :idProduct", nativeQuery = true)
    void update(@Param("nameProduct") String name, @Param("priceProduct") Integer price, @Param("descriptionProduct") String description, @Param("producer") String producer, @Param("idProduct") int id);

    @Modifying
    @Query(value = "update product set status_delete = 0 where id_product = :idProduct", nativeQuery = true)
    void delete(@Param("idProduct") int id);

    @Query(value = "select * from blog where name_product = :nameProduct;", nativeQuery = true)
    Page<Product> findAllProductByName(Pageable pageable, @Param("nameProduct") String name);

}
