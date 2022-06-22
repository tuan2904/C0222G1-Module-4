package com.example.product.Repository;

import com.example.product.Model.Product;
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
    @Query(value = "insert into product (name_product, price, description, manufacturer, status_delete) values (:name, :price, :description, :manufacturer, 1)", nativeQuery = true)
    void save(@Param("name") String name, @Param("price") Integer price, @Param("description") String description, @Param("manufacturer") String manufacturer);

    @Query(value = "select * from product where id_product = :id", nativeQuery = true)
    Product findByIdProduct(@Param("id") Integer id);

    @Modifying
    @Query(value = "update product set name_product = :nameProduct, price = :priceProduct, description = :descriptionProduct, producer = :producerProduct where id_product = :idProduct", nativeQuery = true)
    void update(@Param("nameProduct") String name, @Param("priceProduct") Integer price, @Param("descriptionProduct") String description, @Param("producerProduct") String manufacturer, @Param("idProduct") Integer id);

    @Modifying
    @Query(value = "update product set status_delete = 0 where id_product = :idProduct", nativeQuery = true)
    void delete(@Param("idProduct") Integer id);

    @Query(value = "select * from blog where name_product = :nameProduct;", nativeQuery = true)
    Page<Product> findAllProductByName(Pageable pageable, @Param("nameProduct") String name);

}
