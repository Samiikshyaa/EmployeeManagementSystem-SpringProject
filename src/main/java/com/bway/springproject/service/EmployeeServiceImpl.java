package com.bway.springproject.service;

import com.bway.springproject.model.Employee;
import com.bway.springproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository emprepo;

    @Override
    public void addEmployee(Employee emp) {
        emprepo.save(emp);
    }

    @Override
    public void deleteEmployee(int id) {
        emprepo.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        emprepo.save(emp);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return emprepo.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return emprepo.findAll();
    }
}
