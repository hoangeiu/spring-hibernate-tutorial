package com.hoangle.springboot.cruddemo.service;

import com.hoangle.springboot.cruddemo.dao.EmployeeDAO;
import com.hoangle.springboot.cruddemo.dao.EmployeeRepository;
import com.hoangle.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
//        return employeeDAO.findAll();
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
//        return employeeDAO.findById(theId);
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

//    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
//        return employeeDAO.save(theEmployee);
        return employeeRepository.save(theEmployee);
    }

//    @Transactional
    @Override
    public void deleteById(int theId) {
//        employeeDAO.deleteById(theId);
        employeeRepository.deleteById(theId);
    }
}
