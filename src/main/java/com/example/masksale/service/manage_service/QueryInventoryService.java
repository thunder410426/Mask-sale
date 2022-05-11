package com.example.masksale.service.manage_service;

import com.example.masksale.entity.manage_entity.Purchase;
import com.example.masksale.mapper.manage_mapper.PurchaseMapper;
import com.example.masksale.mapper.manage_mapper.QueryInventoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/2:01
 * @Description:
 */
@Service
public class QueryInventoryService {

    @Resource
    QueryInventoryMapper queryInventoryMapper;

    public Integer queryInventory(String equipmentId){
        return queryInventoryMapper.queryInventory(equipmentId);
    }

}
