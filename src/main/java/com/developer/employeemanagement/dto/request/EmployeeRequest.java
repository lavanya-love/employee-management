package com.developer.employeemanagement.dto.request;
//WRITE DEPENDENCIES IN APPLICATION.PROPERTIES MAPSTRUCT PROCESSOR, MAPSTRUCT CORE

//create requests with mapstruct

//we want the user to give only four values: name, gender, dateofbirth and address and id(sequence should be automated by code))

import java.io.Serializable;
import java.util.Date;

public class EmployeeRequest implements Serializable {//serial number for the id
    private String name;
    private String gender;
    private Date dateofbirth;
    private String address;
    private String email;

    //generate getter and setter

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
}
