package com.example.masksale.service;

import com.example.masksale.entity.Inventory;
import com.example.masksale.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/09/20:13
 * @Description:
 */
@Service
public class InventoryService {

    @Autowired
    InventoryMapper inventoryMapper;

    public void reduce(String equipmentId){
        inventoryMapper.reduceInventoryByFree(equipmentId);
    }

    public int queryInventory(String equimentId){
        return inventoryMapper.queryInventory(equimentId);
    }
}
