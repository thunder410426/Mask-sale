package com.example.masksale.service.manage_service;

import com.example.masksale.entity.RecordOutbound;
import com.example.masksale.entity.manage_entity.QueryOutRecord;
import com.example.masksale.mapper.RecordOutboundMapper;
import com.example.masksale.mapper.manage_mapper.OutRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/11/23:34
 * @Description:
 */
@Service
public class OutRecordService {

    @Resource
    OutRecordMapper outRecordMapper;
    @Resource
    RecordOutboundMapper recordOutboundMapper;

    public List<RecordOutbound> queryOutRecordByName(QueryOutRecord queryOutRecord){
        return outRecordMapper.queryOutRecordByName(queryOutRecord);
    }

    public void deleteByPrimekey(Integer id){
        recordOutboundMapper.deleteByPrimaryKey(id);
    }
}
