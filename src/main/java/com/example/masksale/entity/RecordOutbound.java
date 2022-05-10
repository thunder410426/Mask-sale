package com.example.masksale.entity;

import java.util.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    public String getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }

    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getSaleByn() {
        return saleByn;
    }

    public void setSaleByn(String saleByn) {
        this.saleByn = saleByn;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }
}