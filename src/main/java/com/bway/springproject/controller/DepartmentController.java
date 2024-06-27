package com.bway.springproject.controller;

import com.bway.springproject.model.Department;
import com.bway.springproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentservice;

    @GetMapping("/department")
    public String getDepartmentForm() {
        return "DepartmentForm";
    }

    @PostMapping("/department")
    public String postDepartment(@ModelAttribute Department dept) {
        departmentservice.addDepartment(dept);
        return "DepartmentForm";
    }
}
