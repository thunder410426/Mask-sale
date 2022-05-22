package com.example.masksale.controller.manage_entity;

import com.example.masksale.entity.Inventory;
import com.example.masksale.response.Result;
import com.example.masksale.service.manage_service.QueryInventoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/2:10
 * @Description:
 */
@RestController
@CrossOrigin
public class IntentoryController {

    @Resource
    QueryInventoryService queryInventoryService;

    @PostMapping("/queryInventory")
    public Result<List<Inventory>> queryInventory(String equipmentId){
//        Integer res = queryInventoryMapper.queryInventory(equipmentId);
        List<Inventory> res = queryInventoryService.queryInventory(equipmentId);
        return Result.success(res);
    }

}
