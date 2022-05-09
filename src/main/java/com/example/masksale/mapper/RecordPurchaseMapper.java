package com.example.masksale.mapper;

import com.example.masksale.entity.RecordPurchase;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecordPurchaseMapper {
    @Insert({
        "insert into record_purchase (purchase_id, purchase_num, ",
        "purchase_time, equipment_id)",
        "values (#{purchaseId,jdbcType=VARCHAR}, #{purchaseNum,jdbcType=INTEGER}, ",
        "#{purchaseTime,jdbcType=TIMESTAMP}, #{equipmentId,jdbcType=INTEGER})"
    })
    int insert(RecordPurchase record);

    @Select({
        "select",
        "purchase_id, purchase_num, purchase_time, equipment_id",
        "from record_purchase"
    })
    @Results({
        @Result(column="purchase_id", property="purchaseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="purchase_num", property="purchaseNum", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_time", property="purchaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="equipment_id", property="equipmentId", jdbcType=JdbcType.INTEGER)
    })
    List<RecordPurchase> selectAll();
}