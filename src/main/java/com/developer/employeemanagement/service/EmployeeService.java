package com.developer.employeemanagement.service;

import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

//INTERFACE CONTAINS GET, SAVE, UPDATE, DELETE METHODS ALL SERVICE METHODS

public interface EmployeeService {
    List<EmployeeEntity> findAllEmployee();
    Optional<EmployeeEntity> findById(Long id);

    List<Optional<EmployeeEntity>> findByGender(String gender);

    List<Optional<EmployeeEntity>> findByName(String name);

    List<Optional<EmployeeEntity>> findByEmail(String email);

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    //using request for save and update employee
    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);



    void deleteEmployee(Long id);


    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    //using request for save and update employee
    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id);

}
