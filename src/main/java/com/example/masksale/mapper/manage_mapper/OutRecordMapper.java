package com.example.masksale.mapper.manage_mapper;

import com.example.masksale.entity.RecordOutbound;
import com.example.masksale.entity.manage_entity.QueryOutRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/11/23:05
 * @Description:
 */
@Mapper
@Repository
public interface OutRecordMapper {
    List<RecordOutbound> queryOutRecordByName(@Param("queryOutRecord") QueryOutRecord queryOutRecord);
}
