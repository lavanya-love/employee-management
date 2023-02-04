package com.developer.employeemanagement.service;

import com.developer.employeemanagement.dto.request.DepartmentRequest;
import com.developer.employeemanagement.dto.response.DepartmentResponse;
import com.developer.employeemanagement.entity.DepartmentEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<DepartmentEntity> findAllDept();
    Optional<DepartmentEntity> findById(Long id);

    DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    DepartmentResponse saveDepartment(DepartmentRequest departmentRequest);
}
