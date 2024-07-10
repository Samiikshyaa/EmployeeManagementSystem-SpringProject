package com.bway.springproject.controller;

import com.bway.springproject.model.Employee;
import com.bway.springproject.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String getEmployee(){
        return "EmployeeForm";
    }
    @PostMapping("/employee")
    public String postEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "EmployeeForm";
    }
}
