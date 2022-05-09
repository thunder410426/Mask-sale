package com.example.masksale.mapper;

import com.example.masksale.entity.RecordOutbound;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecordOutboundMapper {
    @Delete({
        "delete from record_outbound",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into record_outbound (id, is_sale, ",
        "buyers_id, buyers_name, ",
        "sale_time, equipment_id, ",
        "sale_byn, order_number, ",
        "is_done)",
        "values (#{id,jdbcType=INTEGER}, #{isSale,jdbcType=INTEGER}, ",
        "#{buyersId,jdbcType=VARCHAR}, #{buyersName,jdbcType=VARCHAR}, ",
        "#{saleTime,jdbcType=TIMESTAMP}, #{equipmentId,jdbcType=INTEGER}, ",
        "#{saleByn,jdbcType=VARCHAR}, #{orderNumber,jdbcType=INTEGER}, ",
        "#{isDone,jdbcType=VARCHAR})"
    })
    int insert(RecordOutbound record);

    @Select({
        "select",
        "id, is_sale, buyers_id, buyers_name, sale_time, equipment_id, sale_byn, order_number, ",
        "is_done",
        "from record_outbound",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_sale", property="isSale", jdbcType=JdbcType.INTEGER),
        @Result(column="buyers_id", property="buyersId", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyers_name", property="buyersName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sale_time", property="saleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="equipment_id", property="equipmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="sale_byn", property="saleByn", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="is_done", property="isDone", jdbcType=JdbcType.VARCHAR)
    })
    RecordOutbound selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, is_sale, buyers_id, buyers_name, sale_time, equipment_id, sale_byn, order_number, ",
        "is_done",
        "from record_outbound"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_sale", property="isSale", jdbcType=JdbcType.INTEGER),
        @Result(column="buyers_id", property="buyersId", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyers_name", property="buyersName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sale_time", property="saleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="equipment_id", property="equipmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="sale_byn", property="saleByn", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="is_done", property="isDone", jdbcType=JdbcType.VARCHAR)
    })
    List<RecordOutbound> selectAll();

    @Update({
        "update record_outbound",
        "set is_sale = #{isSale,jdbcType=INTEGER},",
          "buyers_id = #{buyersId,jdbcType=VARCHAR},",
          "buyers_name = #{buyersName,jdbcType=VARCHAR},",
          "sale_time = #{saleTime,jdbcType=TIMESTAMP},",
          "equipment_id = #{equipmentId,jdbcType=INTEGER},",
          "sale_byn = #{saleByn,jdbcType=VARCHAR},",
          "order_number = #{orderNumber,jdbcType=INTEGER},",
          "is_done = #{isDone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RecordOutbound record);
}