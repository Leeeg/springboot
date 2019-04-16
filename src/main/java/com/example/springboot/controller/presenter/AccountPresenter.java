package com.example.springboot.controller.presenter;

import com.example.springboot.dto.Response;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 19-4-15
 * @Time 下午5:07
 */
public interface AccountPresenter {

    Response login(String userName, String password);

    Response getCode(String phoneNumber);

}
