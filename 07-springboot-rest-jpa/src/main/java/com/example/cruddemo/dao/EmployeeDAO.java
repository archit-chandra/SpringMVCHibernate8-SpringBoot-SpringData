package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAllEmployees();

    Employee findEmployeeById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
