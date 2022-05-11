package com.example.masksale.controller;

import com.example.masksale.entity.User;
import com.example.masksale.response.Result;
import com.example.masksale.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/10/20:47
 * @Description:
 */
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/regist")
    public Result<Void> regist(@RequestBody User user){
        try{
            userService.registry(user);
        }catch (Exception e){
            System.err.println(e);
            return Result.failure("发生错误");
        }
        return Result.success();
    }


}
