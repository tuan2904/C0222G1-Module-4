package com.example.furama.service.customer;

import com.example.furama.model.Customer;
import com.example.furama.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> listCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public void remove(int id) {
        customerRepository.delete(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.editCustomer(customer.getCustomerType().getIdCustomerType(), customer.getNameCustomer(), customer.getBirthDayCustomer(), customer.getGender()
                , customer.getIdCarCustomer(), customer.getPhone(), customer.getEmail(), customer.getEmail(), customer.getIdCustomer());
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findId(id);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> search(Customer customer, Pageable pageable) {
        return customerRepository.search(customer.getNameCustomer(), pageable);
    }
}
