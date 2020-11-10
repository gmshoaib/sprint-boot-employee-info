package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.SalaryGrade;
import com.shoaib.employeeinformation.pojos.SalaryGradePojo;

import java.util.List;
import java.util.Optional;

public interface SalaryGradeService {
    public SalaryGrade createNewSalaryGrade(SalaryGradePojo pojo);

    public Optional<SalaryGrade> getById(Long id);

    public void update(Long id, String name, int gradeLevel);

    public void setBasicSalary(SalaryGradePojo pojo);

    public List<SalaryGrade> getAllList();
}
