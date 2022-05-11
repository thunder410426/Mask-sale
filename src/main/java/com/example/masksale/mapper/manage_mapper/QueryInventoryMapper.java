package com.example.masksale.mapper.manage_mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

    Integer queryInventory (String equipmentId);

}
