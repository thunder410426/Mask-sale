package com.example.masksale.mapper;

import com.example.masksale.entity.Inventory;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

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
}