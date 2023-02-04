package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // INSTEAD OF @CONTROLLER AND @RESPONSEBODY @RESTCONTROLLER IS USED
@RequestMapping("/employee")// TO MAP WEB REQUESTS
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping("/msg")
    public String greeting()
    {
        return "spring security example";
    }

    @GetMapping
    public List<EmployeeEntity> findAllEmployee() {
        return employeeService.findAllEmployee();
    }



    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/getemail")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Optional<EmployeeEntity>> findEmployeeByEmail(@PathVariable("email") String email) {
        return employeeService.findByEmail(email);
    }


    @PostMapping("/add")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }



    @GetMapping("/get")
    public List<Optional<EmployeeEntity>> findEmployeeByGender(@RequestParam("gender") String gender) {
        return employeeService.findByGender(gender);
    }

    @GetMapping("/getname")
    public List<Optional<EmployeeEntity>> findEmployeeByName(@RequestParam("name") String name) {
        return employeeService.findByName(name);
    }

    @PutMapping("/update")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateEmployee(employeeEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    // using request and response for save and update
    //calling the service in controller
    @PostMapping("/{id}")
    public EmployeeResponse saveEmpResponse(@RequestBody EmployeeRequest employeeRequest){
                return employeeService.saveEmployee(employeeRequest);
    }

    public EmployeeResponse updateEmpResponse(@RequestBody EmployeeRequest employeeRequest, @PathVariable("id") Long id) {
        return employeeService.updateEmployee(employeeRequest, id);
    }
}


