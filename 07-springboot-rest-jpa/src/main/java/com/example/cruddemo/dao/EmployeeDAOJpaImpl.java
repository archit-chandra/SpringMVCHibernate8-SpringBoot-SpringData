package com.example.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        // create query
        Query query = entityManager.createQuery("from Employee");
        // execute query and get result list
        // return result
        return (List<Employee>) query.getResultList();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        // update with id from db, so we can get generated id from save/insert
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteEmployeeById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
