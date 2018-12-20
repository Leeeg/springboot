package com.example.springboot.util.response;

import com.example.springboot.dto.Response;
import com.example.springboot.util.ResponseEnum;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-20
 * @Time 上午11:00
 */
public class ResponseUtil {

    public static Response success(Object o){
        Response response = new Response();
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMsg(ResponseEnum.SUCCESS.getMsg());
        response.setData(o);
        return response;
    }

    public static Response error(ResponseEnum anEnum){
        Response response = new Response();
        response.setCode(anEnum.getCode());
        response.setMsg(anEnum.getMsg());
        return response;
    }

}
