package com.developer.employeemanagement.dto.response;

import java.io.Serializable;

public class DepartmentResponse implements Serializable {
    private Long id;
    private String dept_name;

    public DepartmentResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}


