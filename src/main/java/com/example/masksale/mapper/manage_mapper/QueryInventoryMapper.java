package com.example.masksale.mapper.manage_mapper;

import com.example.masksale.entity.Inventory;
import com.example.masksale.mapper.InventoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/2:02
 * @Description:
 */

@Mapper
@Repository
public interface QueryInventoryMapper {

    List<Inventory> queryInventory (@Param("equipmentId") String equipmentId);

}
