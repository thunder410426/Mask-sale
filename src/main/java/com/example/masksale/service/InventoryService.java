package com.example.masksale.service;

import com.example.masksale.entity.Inventory;
import com.example.masksale.entity.RecordOutbound;
import com.example.masksale.mapper.InventoryMapper;
import com.example.masksale.mapper.RecordOutboundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/09/20:13
 * @Description:
 */
@Service
public class InventoryService {

    @Resource
    InventoryMapper inventoryMapper;

    @Resource
    RecordOutboundMapper recordOutboundMapper;

    //减库存
    public void reduce(String equipmentId){
        inventoryMapper.reduceInventoryByFree(equipmentId);
    }

    //查库存
    public int queryInventory(String equimentId){
        return inventoryMapper.queryInventory(equimentId);
    }

    //增加减库存记录
    public void outBoundRecord(RecordOutbound recordOutbound){
        recordOutboundMapper.insert(recordOutbound);
    }
}
