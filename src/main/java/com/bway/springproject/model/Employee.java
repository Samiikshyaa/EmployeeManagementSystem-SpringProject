package com.bway.springproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name = "emp_tbl")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String fname;
    private String lname;
    private String gender;
    private LocalDate dob;
    private String company;
    private String post;
    private int salary;
    private LocalDate joinDate;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @ElementCollection
    @CollectionTable
    private List<String> projects;

}
