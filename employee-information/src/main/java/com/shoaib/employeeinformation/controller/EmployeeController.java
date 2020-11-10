package com.shoaib.employeeinformation.controller;

import com.shoaib.employeeinformation.domain.Employee;
import com.shoaib.employeeinformation.pojos.EmployeePojo;
import com.shoaib.employeeinformation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Employee create(@RequestBody EmployeePojo pojo) {
        return employeeService.create(pojo);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Employee> getAll() {
        return employeeService.getAllList();
    }
}
