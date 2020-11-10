package com.shoaib.employeeinformation.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
@EntityListeners(AuditingEntityListener.class)
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String accountNo;
    @Column(nullable = true)
    private String accountName;
    @Column(nullable = true)
    private String accountType;
    @Column(nullable = true)
    private double currentBalance;
    @ManyToOne
    @JoinColumn
    Bank bank;

}
