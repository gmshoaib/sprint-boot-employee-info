package com.shoaib.employeeinformation.repository;

import com.shoaib.employeeinformation.domain.SalaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalaryGradeRepository extends JpaRepository<SalaryGrade, Long> {

    SalaryGrade findByOrderByGradeLevelDesc();
    List<SalaryGrade> findAllByOrderByGradeLevelDesc();
}
