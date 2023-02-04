package com.developer.employeemanagement.dto.mapper;

import com.developer.employeemanagement.dto.request.DepartmentRequest;
import com.developer.employeemanagement.dto.response.DepartmentResponse;
import com.developer.employeemanagement.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER= Mappers.getMapper(DepartmentMapper.class);
    DepartmentEntity fromRequestToEntity(DepartmentRequest departmentRequest);
    DepartmentResponse fromEntityToResponse(DepartmentEntity departmentEntity);
}
