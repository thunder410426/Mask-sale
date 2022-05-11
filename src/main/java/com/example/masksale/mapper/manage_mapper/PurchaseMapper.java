package com.example.masksale.mapper.manage_mapper;

import com.example.masksale.entity.RecordPurchase;
import com.example.masksale.entity.manage_entity.Purchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/1:21
 * @Description:
 */

@Mapper
@Repository
public interface PurchaseMapper {

    void purchase(@Param("purchase") Purchase purchase);

    void purchaseRecord(@Param("recordPurchase") RecordPurchase recordPurchase);
}
