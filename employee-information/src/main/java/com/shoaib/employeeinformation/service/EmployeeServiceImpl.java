package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.BankAccount;
import com.shoaib.employeeinformation.domain.Employee;
import com.shoaib.employeeinformation.domain.SalaryGrade;
import com.shoaib.employeeinformation.pojos.EmployeePojo;
import com.shoaib.employeeinformation.repository.BankAccountJpaRepository;
import com.shoaib.employeeinformation.repository.EmployeeJpaRepository;
import com.shoaib.employeeinformation.repository.SalaryGradeRepository;
import com.shoaib.employeeinformation.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    SalaryGradeRepository salaryGradeRepository;
    @Autowired
    BankAccountJpaRepository bankAccountJpaRepository;
    @Autowired
    EmployeeJpaRepository employeeJpaRepository;
    public Employee create(EmployeePojo pojo) {
        Employee employee = new Employee();
        try {
            Optional<SalaryGrade> grade = salaryGradeRepository.findById(pojo.gradeId);
            Optional<BankAccount> account = bankAccountJpaRepository.findById(pojo.accountId);
            if(grade.isPresent() && account.isPresent()) {
                SalaryGrade salaryGrade = grade.get();
                BankAccount bankAccount = account.get();

                employee.setName(pojo.name);
                employee.setEmployeeId(pojo.employeeId);
                employee.setAddress(pojo.address);
                employee.setMobileNo(pojo.mobileNo);
                employee.setBankAccount(bankAccount);
                employee.setSalaryGrade(salaryGrade);

                double bSalary = salaryGrade.getBasicSalary();
                double mAllowance = ( bSalary * Constant.MEDICAL_ALLOWANCE_PERCENT) / 100.00;
                double hRent = ( bSalary * Constant.HOUSE_RENT_PERCENT) / 100.00;
                double gSalary = bSalary + mAllowance + hRent;

                employee.setBasicSalary(bSalary);
                employee.setMedicalAllowance(mAllowance);
                employee.setHouseRent(hRent);
                employee.setGrossSalary(gSalary);

                employeeJpaRepository.save(employee);

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return employee;
    }


    public List<Employee> getAllList() {
        return employeeJpaRepository.findAll();
    }
}
