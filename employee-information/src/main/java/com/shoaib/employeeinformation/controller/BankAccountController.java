package com.shoaib.employeeinformation.controller;

import com.shoaib.employeeinformation.domain.BankAccount;
import com.shoaib.employeeinformation.pojos.BankAccountPojo;
import com.shoaib.employeeinformation.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/bankAccount")
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public BankAccount create(@RequestBody BankAccountPojo pojo) {
        return bankAccountService.createNewAccount(pojo);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<BankAccount> getAll() {
        return bankAccountService.getAllList();
    }
}
