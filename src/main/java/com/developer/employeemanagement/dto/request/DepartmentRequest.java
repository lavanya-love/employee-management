package com.developer.employeemanagement.dto.request;

import java.io.Serializable;

public class DepartmentRequest implements Serializable {//serial number for the id
    private String dept_name;

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
