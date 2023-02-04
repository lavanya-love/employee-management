package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// JPA REPOSITORY HAS 2 PARAMETERS (ENTITY , PRIMARY KEY DATATYPE)
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<Optional<EmployeeEntity>> findByGender(String gender);

    List<Optional<EmployeeEntity>> findByName(String name);

    List<Optional<EmployeeEntity>> findByEmail(String email);
}
