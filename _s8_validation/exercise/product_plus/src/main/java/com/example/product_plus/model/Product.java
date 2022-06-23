package com.example.product_plus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "products")
public class Product {
    @Id
    @Column(name = "id_product", columnDefinition = "INT")
    private int idProduct;

    @Column(name = "name_product", columnDefinition = "VARCHAR(200)")
    @NotBlank(message = "Tên không được để trống!")
    @Size(min = 20, max = 800, message = "Không được quá 800 ký tự")
    private String nameProduct;

    @Column(name = "price_product", columnDefinition = "DOUBLE")
    @NotBlank(message = "Price không được để trống!")
    @Size(min = 0,message = "Price không được nhỏ hơn 0")
    private String priceProduct;

    @Column(name = "describe_product", columnDefinition = "VARCHAR(200)")
    @NotBlank(message = " Không được để trống!")
    private String describeProduct;

    @Column(name = "producer_product", columnDefinition = "VARCHAR(200)")
    @NotBlank(message = "Không được để trống!")
    private String producerProduct;

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public String getProducerProduct() {
        return producerProduct;
    }

    public void setProducerProduct(String producerProduct) {
        this.producerProduct = producerProduct;
    }


