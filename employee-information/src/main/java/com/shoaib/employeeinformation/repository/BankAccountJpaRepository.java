package com.shoaib.employeeinformation.repository;

import com.shoaib.employeeinformation.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccount, Long> {
}
