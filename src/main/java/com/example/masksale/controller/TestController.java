package com.example.masksale.controller;

import com.example.masksale.entity.Inventory;
import com.example.masksale.entity.User;
import com.example.masksale.response.Result;
import com.example.masksale.service.InventoryService;
import com.example.masksale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/09/18:35
 * @Description:
 */
@RestController
public class TestController {

    @Resource
    InventoryService inventoryService;
    @Resource
    UserService userService;

    @PostMapping("aaa")
    public String test(){
        return "success";
    }

    @PostMapping("/reduce")
    public Result<Void> reduce(@RequestParam String equipmentId){
        if (inventoryService.queryInventory(equipmentId) <= 0){
            return Result.failure("对不起，库存不足");
        }else {
            inventoryService.reduce(equipmentId);
            return Result.success();
        }
    }

    @PostMapping("/regist")
    public Result<Void> regist(@RequestBody User user){
        try{
            userService.registry(user);
        }catch (Exception e){
            System.err.println(e);
            return Result.failure("发生错误");
        }
        return Result.success();
    }
}
