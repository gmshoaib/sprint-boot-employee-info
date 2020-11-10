package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.Bank;
import com.shoaib.employeeinformation.pojos.BankPojo;
import com.shoaib.employeeinformation.repository.BankJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankServiceImpl implements BankService{

    @Autowired
    BankJpaRepository bankJpaRepository;
    @Transactional
    public Bank createNewBank(BankPojo pojo) {
        Bank bank = new Bank();
        try {
            bank.setName(pojo.name);
            bank.setBranchName(pojo.branchName);
            bank.setCode(pojo.code);
            bankJpaRepository.save(bank);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return bank;
    }

    public List<Bank> getAllList() {
        return bankJpaRepository.findAll();
    }
}
