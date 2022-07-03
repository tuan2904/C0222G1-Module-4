package com.example.furama.service.service;

import com.example.furama.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    Page<Service> listService(Pageable pageable);

    List<Service> list();

    void remove(int id);

    void update(Service service);

    Service findById(int id);

    void create(Service service);

    Page<Service> search(Service service, Pageable pageable);

}
