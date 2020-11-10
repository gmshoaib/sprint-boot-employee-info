package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.Employee;
import com.shoaib.employeeinformation.pojos.EmployeePojo;

import java.util.List;

public interface EmployeeService {

    public Employee create(EmployeePojo pojo);

    public List<Employee> getAllList();
}
