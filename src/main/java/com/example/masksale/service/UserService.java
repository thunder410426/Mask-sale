package com.example.masksale.service;

import com.example.masksale.entity.User;
import com.example.masksale.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/09/23:39
 * @Description:
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public void registry(User user){
        Date date =new Date();
        if (userMapper.selectUserIfExits(user.getNickName()).size() == 0){
            user.setRegisteTime(date);
            userMapper.insert(user);
        }
    }
}
