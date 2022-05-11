package com.example.masksale.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RecordPurchase {
    private String purchaseId;

    private Integer purchaseNum;

    private Date purchaseTime;

    private String equipmentId;

}