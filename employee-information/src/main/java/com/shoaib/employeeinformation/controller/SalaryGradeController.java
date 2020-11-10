package com.shoaib.employeeinformation.controller;

import com.shoaib.employeeinformation.domain.SalaryGrade;
import com.shoaib.employeeinformation.pojos.SalaryGradePojo;
import com.shoaib.employeeinformation.service.SalaryGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/salaryGrade")
public class SalaryGradeController {

    @Autowired
    SalaryGradeService salaryGradeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public SalaryGrade create(@RequestBody SalaryGradePojo pojo) {
        return salaryGradeService.createNewSalaryGrade(pojo);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Optional<SalaryGrade> getById(Long id) {
        return salaryGradeService.getById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(Long id, String name, int gradeLevel) {
        salaryGradeService.update(id, name, gradeLevel);
    }

    @RequestMapping(value = "/setBasic", method = RequestMethod.POST)
    public void setBasic(@RequestBody SalaryGradePojo pojo) {
        salaryGradeService.setBasicSalary(pojo);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<SalaryGrade> getAll() {
        return salaryGradeService.getAllList();
    }
}
