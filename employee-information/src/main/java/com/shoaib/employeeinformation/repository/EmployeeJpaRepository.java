package com.shoaib.employeeinformation.repository;

import com.shoaib.employeeinformation.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
}
