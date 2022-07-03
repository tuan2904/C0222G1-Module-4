package com.example.furama.service.employee;

import com.example.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> listEmployee(Pageable pageable);

    void remove(int id);

    void update(Employee employee);

    Employee findById(int id);

    void create(Employee employee);
    Page<Employee> search(Employee employee,Pageable pageable);
}
