package com.example.masksale.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String nickName;

    private Date registeTime;

    private String openId;

}