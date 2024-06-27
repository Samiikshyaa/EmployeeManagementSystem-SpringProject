package com.bway.springproject.service;

import com.bway.springproject.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void addDepartment(Department dept);
    void deleteDept(int depId);
    void updateDept(Department dept);
    Department getDeptById(int dept_id);
    List<Department> getAllDept();
}
