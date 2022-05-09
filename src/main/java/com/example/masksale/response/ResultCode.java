package com.example.masksale.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/09/22:35
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    //成功提示码
    SUCCESS(20000, "成功"),

    //自定义失败信息
    FAILURE(50000, "失败"),

    //通用错误码 50001~50099
    PROGRAM_INSIDE_EXCEPTION(50001, "程序内部异常"),
    REQUEST_PARAM_ERROR(50002, "请求参数错误");

    //用户模块错误码 50100~50199
    //商品模块错误码 50200~50299
    //订单模块错误码 50300~50399

    private final Integer code;
    private final String message;
}