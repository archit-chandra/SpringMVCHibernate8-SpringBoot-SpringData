package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAllEmployees();
}
