package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.SalaryGrade;
import com.shoaib.employeeinformation.pojos.SalaryGradePojo;
import com.shoaib.employeeinformation.repository.SalaryGradeRepository;
import com.shoaib.employeeinformation.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SalaryGradeServiceImpl implements SalaryGradeService {


    @Autowired
    SalaryGradeRepository salaryGradeRepository;
    @Transactional
    public SalaryGrade createNewSalaryGrade(SalaryGradePojo pojo) {
        SalaryGrade grade = new SalaryGrade();
        try {
            grade.setName(pojo.name);
          //  int level = Integer.parseInt(pojo.gradeLevel);
            grade.setGradeLevel(pojo.gradeLevel);
            salaryGradeRepository.save(grade);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return grade;
    }

   @Override
   public Optional<SalaryGrade> getById(Long id){
        return  salaryGradeRepository.findById(id);
    }

    @Transactional
    public void update(Long id, String name, int gradeLevel) {
        Optional<SalaryGrade> grade = salaryGradeRepository.findById(id);
        SalaryGrade grade1;
        try {
            if(grade.isPresent()) {
                grade1 = grade.get();
                grade1.setName(name);
                grade1.setGradeLevel(gradeLevel);
                salaryGradeRepository.save(grade1);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setBasicSalary(SalaryGradePojo pojo) {
        try {
            List<SalaryGrade> gradeList = salaryGradeRepository.findAllByOrderByGradeLevelDesc();
            double amount = pojo.amount;
            for(SalaryGrade salaryGrade : gradeList) {
                salaryGrade.setBasicSalary(amount);
                amount += Constant.BASIC_ADDED;
                salaryGradeRepository.save(salaryGrade);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List<SalaryGrade> getAllList() {
        return salaryGradeRepository.findAllByOrderByGradeLevelDesc();
    }
}
