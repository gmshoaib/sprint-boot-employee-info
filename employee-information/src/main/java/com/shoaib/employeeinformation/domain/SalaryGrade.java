package com.shoaib.employeeinformation.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "salary_grade")
@EntityListeners(AuditingEntityListener.class)

@Data
public class SalaryGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(unique=true)
    private int gradeLevel;
    @Column(nullable = true)
    private double basicSalary;
}
