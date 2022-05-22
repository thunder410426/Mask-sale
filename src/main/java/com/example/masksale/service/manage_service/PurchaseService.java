package com.example.masksale.service.manage_service;

import com.example.masksale.entity.RecordPurchase;
import com.example.masksale.entity.User;
import com.example.masksale.entity.manage_entity.Purchase;
import com.example.masksale.mapper.RecordPurchaseMapper;
import com.example.masksale.mapper.manage_mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/1:39
 * @Description:
 */
@Service
public class PurchaseService {

    @Resource
    PurchaseMapper purchaseMapper;
    @Resource
    RecordPurchaseMapper recordPurchaseMapper;

    public void purchase(Purchase purchase){

        //进货
        purchaseMapper.purchase(purchase);

        RecordPurchase recordPurchase = new RecordPurchase();
        recordPurchase.setEquipmentId(purchase.getEquipmentId());
        recordPurchase.setPurchaseNum(purchase.getPurchaseNum());
        Date date =new Date();
        recordPurchase.setPurchaseTime(date);

        //添加进货记录
        purchaseMapper.purchaseRecord(recordPurchase);

    }

    public List<RecordPurchase> selectPurchaseRecord(){
        return recordPurchaseMapper.selectAll();
    }

}
