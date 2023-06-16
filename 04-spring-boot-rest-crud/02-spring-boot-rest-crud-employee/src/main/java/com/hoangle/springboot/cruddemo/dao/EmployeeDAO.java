package com.hoangle.springboot.cruddemo.dao;

import com.hoangle.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
