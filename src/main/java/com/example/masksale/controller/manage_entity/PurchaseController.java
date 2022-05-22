package com.example.masksale.controller.manage_entity;

import com.example.masksale.entity.RecordPurchase;
import com.example.masksale.entity.User;
import com.example.masksale.entity.manage_entity.Purchase;
import com.example.masksale.response.Result;
import com.example.masksale.service.manage_service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/1:20
 * @Description:
 */
@RestController
@CrossOrigin
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/purchase")
    public Result<Void> purchase(@RequestBody Purchase purchase){
        purchaseService.purchase(purchase);
        return Result.success();
    }

    @PostMapping("/selectPurchaseRecord")
    public Result<List<RecordPurchase>> purchaseRecord(){
        return Result.success(purchaseService.selectPurchaseRecord());
    }

}
