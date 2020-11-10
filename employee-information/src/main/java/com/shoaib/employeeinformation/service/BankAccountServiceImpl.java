package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.Bank;
import com.shoaib.employeeinformation.domain.BankAccount;
import com.shoaib.employeeinformation.pojos.BankAccountPojo;
import com.shoaib.employeeinformation.repository.BankAccountJpaRepository;
import com.shoaib.employeeinformation.repository.BankJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    BankAccountJpaRepository bankAccountJpaRepository;
    @Autowired
    BankJpaRepository bankJpaRepository;

    @Transactional
    public BankAccount createNewAccount(BankAccountPojo pojo) {
        BankAccount bankAccount = new BankAccount();
        try {
            Bank bank = bankJpaRepository.findByCode(pojo.bankCode);
            if(bank != null) {
                bankAccount.setAccountName(pojo.accountName);
                bankAccount.setAccountNo(pojo.accountNo);
                bankAccount.setAccountType(pojo.accountType);
                bankAccount.setCurrentBalance(pojo.currentBalance);
                bankAccount.setBank(bank);
            bankAccountJpaRepository.save(bankAccount);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return bankAccount;
    }

    public List<BankAccount> getAllList() {
        return bankAccountJpaRepository.findAll();
    }
}
