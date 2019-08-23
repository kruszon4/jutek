package com.jutek.JUTEK.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    private Integer billId;
    private Integer userId;
    private Double transactionValue;



}
