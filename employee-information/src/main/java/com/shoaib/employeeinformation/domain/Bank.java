package com.shoaib.employeeinformation.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String branchName;
    @Column(nullable = false)
    private String code;
}

