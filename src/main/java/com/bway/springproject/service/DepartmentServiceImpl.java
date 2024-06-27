package com.bway.springproject.service;

import com.bway.springproject.model.Department;
import com.bway.springproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    @Override
    public void addDepartment(Department dept) {
        departmentRepo.save(dept);
    }

    @Override
    public void deleteDept(int depId) {
        departmentRepo.deleteById(depId);
    }

    @Override
    public void updateDept(Department dept) {
        departmentRepo.save(dept);
    }

    @Override
    public Department getDeptById(int dept_id) {
        return departmentRepo.findById(dept_id).get();
    }

    @Override
    public List<Department> getAllDept() {
        return departmentRepo.findAll();
    }
}
