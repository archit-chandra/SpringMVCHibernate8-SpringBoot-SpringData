package com.example.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new EmployeeNotFoundException("Employee not found for id - " + id);
        }
        return employee;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
