package com.example.masksale.mapper;

import com.example.masksale.entity.Inventory;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InventoryMapper {
    @Insert({
        "insert into inventory (mask_num, equipment_id)",
        "values (#{maskNum,jdbcType=INTEGER}, #{equipmentId,jdbcType=INTEGER})"
    })
    int insert(Inventory record);

    @Select({
        "select",
        "mask_num, equipment_id",
        "from inventory"
    })
    @Results({
        @Result(column="mask_num", property="maskNum", jdbcType=JdbcType.INTEGER),
        @Result(column="equipment_id", property="equipmentId", jdbcType=JdbcType.INTEGER)
    })
    List<Inventory> selectAll();

    @Select({
            "select",
            "mask_num",
            "from inventory",
            "where equipment_id = #{equipmentId}"
    })
    @Results({
            @Result(column="mask_num", property="maskNum", jdbcType=JdbcType.INTEGER),
    })
    int queryInventory(String equipmentId);

    @Update({
            "update inventory",
            "set mask_num = mask_num - 1",
            "where equipment_id = #{equipmentId,jdbcType=VARCHAR}"
    })
    void reduceInventoryByFree(String equipmentId);
}