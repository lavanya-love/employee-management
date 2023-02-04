package com.developer.employeemanagement.service.implement;


import com.developer.employeemanagement.dto.mapper.EmployeeMapper;
import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.repository.EmployeeRepository;
import com.developer.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//SERVICE IMPLEMENT IS USED TO WORK WITH THE REPOSITORY
//TO IMPLEMENT SERVICE METHODS

@Service //TO CONFIRM THAT IT IS A SERVICE
public class EmployeeServiceImplement implements EmployeeService {

    private final EmployeeRepository employeeRepository; // CALL REPOSITORY TO USE IN THIS SERVICE
    public EmployeeServiceImplement(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Optional<EmployeeEntity>> findByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    @Override
    public List<Optional<EmployeeEntity>> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    @Override
    public List<Optional<EmployeeEntity>> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    //SAVE EMPLOYEE
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {

        EmployeeEntity employeeEntity = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        employeeRepository.save(employeeEntity);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employeeEntity);
    }


    //DELETE EMPLOYEE
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    // using request and response for save and update with employee data
    // we need one more mapper class between Employee Request and employee Entity
    //and employee entity amd employee response


    //UPDATE EMPLOYEE
    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id) {

        Optional<EmployeeEntity> checkExistingEmployee = findById(id);

        if(! checkExistingEmployee.isPresent())
            throw new RuntimeException("Employee id"+ id + "not present");


        EmployeeEntity employeeEntity = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        employeeEntity.setId(id);
        employeeRepository.save(employeeEntity);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employeeEntity);
    }


}
