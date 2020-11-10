package com.shoaib.employeeinformation.repository;

import com.shoaib.employeeinformation.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankJpaRepository extends JpaRepository<Bank, Long> {

    Bank findByCode(String code);

}
