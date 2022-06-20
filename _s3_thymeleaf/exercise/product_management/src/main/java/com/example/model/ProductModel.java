package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product_table")
public class ProductModel {
    @Id
    @Column(name = "id_product", columnDefinition = "INT")
    private int idProduct;
    @Column(name = "name_product", columnDefinition = "VARCHAR(200)")
    private String nameProduct;
    @Column(name = "price_product", columnDefinition = "DOUBLE")
    private double priceProduct;
    @Column(name = "describe_product", columnDefinition = "VARCHAR(200)")
    private String describeProduct;
    @Column(name = "producer_product", columnDefinition = "VARCHAR(200)")
    private String producerProduct;

    public ProductModel() {
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

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
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
}
