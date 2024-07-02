package com.bway.springproject.controller;

import com.bway.springproject.model.Department;
import com.bway.springproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/departmentlist")
    public String showDepartmentList(Model model){
        model.addAttribute("dlist",departmentservice.getAllDept());
        return "DepartmentListForm";
    }

    @GetMapping("/dept/delete")
    public String delete(@RequestParam int id){
        departmentservice.deleteDept(id);
        return "redirect:/departmentlist";
    }

    @GetMapping("/dept/edit")
    public String edit(@RequestParam int id, Model model){
        model.addAttribute("dmodel",departmentservice.getDeptById(id));
        return "DepartmentEditForm";
    }
    @PostMapping("/dept/update")
    public String update(@ModelAttribute Department dept){
        departmentservice.updateDept(dept);
        return "redirect:/departmentlist";
    }
}
