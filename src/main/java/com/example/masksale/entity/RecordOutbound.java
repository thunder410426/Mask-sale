package com.example.masksale.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RecordOutbound {
    private Integer id;

    private Integer isSale;

    private String buyersId;

    private String buyersName;

    private Date saleTime;

    private String equipmentId;

    private String saleByn;

    private String orderNumber;

    private String isDone;

}