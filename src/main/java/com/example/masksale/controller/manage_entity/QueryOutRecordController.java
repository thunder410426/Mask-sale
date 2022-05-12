package com.example.masksale.controller.manage_entity;

import com.example.masksale.entity.RecordOutbound;
import com.example.masksale.entity.manage_entity.QueryOutRecord;
import com.example.masksale.response.Result;
import com.example.masksale.service.manage_service.OutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/11/23:44
 * @Description:
 */
@RestController
public class QueryOutRecordController {

    @Autowired
    OutRecordService outRecordService;

    //查询出货记录，传buyersName则根据条件查找，不传则全查
    @PostMapping("/queryInventoryByName")
    public Result<List<RecordOutbound>> queryInventoryByName(@RequestBody QueryOutRecord queryOutRecord){
        return Result.success(outRecordService.queryOutRecordByName(queryOutRecord));
    }
}
