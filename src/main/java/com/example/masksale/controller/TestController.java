package com.example.masksale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/09/18:35
 * @Description:
 */
@RestController
public class TestController {
    @RequestMapping("aaa")
    public String test(){
        return "success";
    }
}
