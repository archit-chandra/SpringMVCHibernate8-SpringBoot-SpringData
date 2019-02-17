package com.example.cruddemo.service;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
