package com.example.springboot.util;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-20
 * @Time 上午11:01
 */
public enum ResponseEnum {

    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    USER_NOT_EXIST(401,"用户不存在"),
    REQUEST_INVALID(400,"无效请求"),
    DATA_IS_NULL(201,"目标不存在"),
    INSERT_FAILED(501,"添加失败");

    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
