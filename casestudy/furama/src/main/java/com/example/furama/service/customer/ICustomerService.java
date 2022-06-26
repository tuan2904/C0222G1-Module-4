package com.example.furama.service.customer;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> listCustomer(Pageable pageable);

    void remove(int id);

    void update(Customer customer);

    Customer findById(int id);

    void create(Customer customer);
    Page<Customer> search(Customer customer,Pageable pageable);

}
