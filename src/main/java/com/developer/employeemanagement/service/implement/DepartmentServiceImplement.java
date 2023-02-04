package com.developer.employeemanagement.service.implement;

import com.developer.employeemanagement.dto.mapper.DepartmentMapper;
import com.developer.employeemanagement.dto.request.DepartmentRequest;
import com.developer.employeemanagement.dto.response.DepartmentResponse;
import com.developer.employeemanagement.entity.DepartmentEntity;
import com.developer.employeemanagement.repository.DepartmentRepository;
import com.developer.employeemanagement.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartmentServiceImplement implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImplement(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    @Override
    public List<DepartmentEntity> findAllDept() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<DepartmentEntity> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentResponse saveDepartment(DepartmentRequest departmentRequest) {

        DepartmentEntity departmentEntity = DepartmentMapper.MAPPER.fromRequestToEntity(departmentRequest);
        departmentRepository.save(departmentEntity);
        return DepartmentMapper.MAPPER.fromEntityToResponse(departmentEntity);
    }
}
