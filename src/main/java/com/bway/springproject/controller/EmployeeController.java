package com.bway.springproject.controller;

import com.bway.springproject.model.Employee;
import com.bway.springproject.service.DepartmentService;
import com.bway.springproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/employee")
    public String getEmployee(Model model) {
        model.addAttribute("deplist", departmentService.getAllDept());
        return "EmployeeForm";
    }

    @PostMapping("/employee")
    public String postEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employeelist")
    public String getEmployeeList(Model model) {
        model.addAttribute("elist", employeeService.getAllEmployee());
        return "EmployeeList";
    }

    @GetMapping("/employee/delete")
    public String delete(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employeelist";
    }

    @GetMapping("/employee/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("emodel", employeeService.getEmployeeById(id));
        model.addAttribute("deplist", departmentService.getAllDept());
        return "EmployeeEdit";
    }
    @PostMapping("/employee/update")
    public String update(@ModelAttribute Employee emp) {
        employeeService.updateEmployee(emp);
        return "redirect:/employeelist";
    }


}
