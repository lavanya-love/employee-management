package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.entity.DepartmentEntity;
import com.developer.employeemanagement.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // INSTEAD OF @CONTROLLER AND @RESPONSEBODY @RESTCONTROLLER IS USED
@RequestMapping("/Dept")// TO MAP WEB REQUESTS

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentEntity> findAllDept(){return departmentService.findAllDept();}


    @GetMapping("/{id}")
    public Optional<DepartmentEntity> findDeptById(@PathVariable("id") Long id) {
        return departmentService.findById(id);
    }

    @PostMapping("/add")
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.saveDepartment(departmentEntity);
    }
}
