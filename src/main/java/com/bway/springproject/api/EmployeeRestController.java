package com.bway.springproject.api;

import com.bway.springproject.model.Employee;
import com.bway.springproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/emp/list")
    public List<Employee> getAll(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/api/emp/add")
    public String add(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "added success";
    }

    @GetMapping("/api/emp/{id}")
    public Employee getOne(@PathVariable int id){

        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/api/emp/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "delete success";
    }

    @PutMapping("/api/emp/update")
    public String update(@RequestBody Employee emp){
        employeeService.updateEmployee(emp);
        return "update success";
    }

}
