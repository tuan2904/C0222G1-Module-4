package com.example.furama.service.service;

import com.example.furama.model.Customer;
import com.example.furama.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    Page<Service> listService(Pageable pageable);

    void remove(int id);

    void update(Service service);

    Service findById(int id);

    void create(Service service);
    Page<Service> search(Service service,Pageable pageable);

}
