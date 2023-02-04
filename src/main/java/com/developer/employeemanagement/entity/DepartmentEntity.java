package com.developer.employeemanagement.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long id;

    @NonNull
    @Column(name = "dept_name")
    private String dept_name;


   @OneToOne(mappedBy = "departmentEntity")
    private EmployeeEntity employeeEntity;


    /*//One department has multiple employees
    @OneToMany(targetEntity = EmployeeEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name= "fk_dept_id",referencedColumnName = "dept_id")
    private List<EmployeeEntity> employeeEntity;*/



   /* //unidirectional one-to-many
    @OneToMany(cascade = CascadeType.ALL) //one department many employees
    @JoinColumn(name = "fk_dept_id",referencedColumnName = "dept_id")
    private List<EmployeeEntity> employeeEntities;*/



   /* @JsonIgnore
    @OneToMany //one department many employees
    @JoinColumn(name = "dept_id")
    private Set<EmployeeEntity> employeeEntities;
    *?
    */



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(@NonNull String dept_name) {
        this.dept_name = dept_name;
    }

   /* public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }*/
}
