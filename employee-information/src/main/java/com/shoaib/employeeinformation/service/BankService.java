package com.shoaib.employeeinformation.service;

import com.shoaib.employeeinformation.domain.Bank;
import com.shoaib.employeeinformation.pojos.BankPojo;

import java.util.List;

public interface BankService {

    public Bank createNewBank(BankPojo pojo);

    public List<Bank> getAllList();
}
