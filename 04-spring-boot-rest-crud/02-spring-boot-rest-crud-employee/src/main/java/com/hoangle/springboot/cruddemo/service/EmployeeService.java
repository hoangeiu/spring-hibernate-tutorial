package com.hoangle.springboot.cruddemo.service;

import com.hoangle.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
