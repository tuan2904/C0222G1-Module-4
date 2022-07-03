package com.example.furama.service.employee;

import com.example.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> listEmployee(Pageable pageable);

    List<Employee> list();

    void remove(int id);

    void update(Employee employee);

    Employee findById(int id);

    void create(Employee employee);

    Page<Employee> search(Employee employee, Pageable pageable);
}
