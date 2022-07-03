package com.example.furama.service.employee;

import com.example.furama.model.Employee;
import com.example.furama.repository.IEmployeeRepository;
import com.example.furama.service.division.IDivisionService;
import com.example.furama.service.educationdegree.IEducationDegreeService;
import com.example.furama.service.position.IPositionService;
import com.example.furama.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Override
    public Page<Employee> listEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void remove(int id) {
    employeeRepository.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee.getAddress(), employee.getBirthDayEmployee(), employee.getEmail(), employee.getIdCarEmployee(), employee.getNameEmployee()
                , employee.getPhone(), employee.getSalary(), employee.getDivision().getIdDivision(), employee.getEducationDegree().getIdEducationDegree()
                , employee.getPosition().getIdPosition(), employee.getUser().getUsername(), employee.getIdEmployee());
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findId(id);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> search(Employee employee, Pageable pageable) {
        return employeeRepository.search(employee.getNameEmployee(),pageable);
    }
}
