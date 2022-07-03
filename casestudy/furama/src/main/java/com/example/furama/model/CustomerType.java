package com.example.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "customerType")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomerType;
    @Column(name = "name_customer_type", columnDefinition = "VARCHAR(200)")
    private String nameCustomerType;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType(int idCustomerType, String nameCustomerType) {
        this.idCustomerType = idCustomerType;
        this.nameCustomerType = nameCustomerType;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public CustomerType() {
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
}
