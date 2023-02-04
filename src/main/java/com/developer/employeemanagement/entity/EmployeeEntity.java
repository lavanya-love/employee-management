package com.developer.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

//CREATE TABLES IN THE DATABASE
@Entity
@Table(name = "database2")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id") // COLUMN NAMES
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private Date dateofbirth;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    //One employee has only one department
    @OneToOne(cascade = CascadeType.ALL) //by default creates a foreign key column in database 2 with
    // deptartmentEntity_dept_id
    //if u want custom name u can use @joinColumn
    @JoinColumn(name = "fk_dept_id") //fk:foreign key
    private DepartmentEntity departmentEntity;
    //For one to many no need to reference



    // for bidirectional one to one mapping
    //@OneToOne(mappedBy = "address")
    //private Employee employee;

   /* @ManyToOne
    @JoinColumn(name = "fk_dept_id")
    private DepartmentEntity departmentEntity;*/

   /* @ManyToOne
    @JoinColumn(name = "dept_id")
    private DepartmentEntity departmentEntity;*/




    public EmployeeEntity(Long id, String name, String gender, Date dateofbirth, String address, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.email = email;

    }

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender +", dob =" + dateofbirth +", adderss =" +
                address + ", email =" + email + "]";
    }

}
