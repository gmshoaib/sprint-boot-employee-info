package com.shoaib.employeeinformation.controller;

import com.shoaib.employeeinformation.domain.Bank;
import com.shoaib.employeeinformation.pojos.BankPojo;
import com.shoaib.employeeinformation.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/bank")
public class BankController {

    @Autowired
    BankService bankService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Bank create(@RequestBody BankPojo pojo) {
        return bankService.createNewBank(pojo);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Bank> getAll() {
        return bankService.getAllList();
    }
}
