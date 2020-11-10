package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.BankAccount;
import com.shoaib.employeeinformation.pojos.BankAccountPojo;

import java.util.List;

public interface BankAccountService {

    public BankAccount createNewAccount(BankAccountPojo pojo);

    public List<BankAccount> getAllList();
}
