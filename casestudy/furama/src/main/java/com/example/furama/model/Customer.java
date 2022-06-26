package com.example.furama.model;

import javax.persistence.*;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;
    @Column(name = "name_customer", columnDefinition = "VARCHAR(200)")
    private String nameCustomer;
    @Column(name = "birth_dayCustomer", columnDefinition = "VARCHAR(200)")
    private String birthDayCustomer;
    @Column(columnDefinition = "VARCHAR(200)")
    private String gender;
    @Column(name = "id_car_customer", columnDefinition = "VARCHAR(200)")
    private String idCarCustomer;
    @Column(name = "phone",columnDefinition = "VARCHAR(200)")
    private String phone;
    @Column(name = "email",columnDefinition = "VARCHAR(200)")
    private String email;
    @Column(name = "address",columnDefinition = "VARCHAR(200)")
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_customer_type")
    private CustomerType customerType;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer() {
    }

    public Customer(int idCustomer,
                    String nameCustomer,
                    String birthDayCustomer,
                    String gender,
                    String idCarCustomer,
                    String phone, String email,
                    String address) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.birthDayCustomer = birthDayCustomer;
        this.gender = gender;
        this.idCarCustomer = idCarCustomer;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthDayCustomer() {
        return birthDayCustomer;
    }

    public void setBirthDayCustomer(String birthDayCustomer) {
        this.birthDayCustomer = birthDayCustomer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCarCustomer() {
        return idCarCustomer;
    }

    public void setIdCarCustomer(String idCarCustomer) {
        this.idCarCustomer = idCarCustomer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
