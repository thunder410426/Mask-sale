package com.example.masksale.controller.manage_entity;

import com.example.masksale.mapper.manage_mapper.QueryInventoryMapper;
import com.example.masksale.response.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/2:10
 * @Description:
 */
@RestController
@CrossOrigin
public class QueryIntentoryController {

    @Resource
    QueryInventoryMapper queryInventoryMapper;

    @PostMapping("/queryInventory")
    public Result<Integer> queryInventory(String equipmentId){
        Integer res = queryInventoryMapper.queryInventory(equipmentId);
        return Result.success(res);
    }

}
