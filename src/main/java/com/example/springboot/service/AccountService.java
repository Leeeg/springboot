package com.example.springboot.service;

import com.example.springboot.entity.Account;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 19-4-16
 * @Time 下午3:46
 */
public interface AccountService {

    Integer getCode(String phoneNumber, String code);

    Integer register(String userName, String password, String phone);

    Account login(String userName, String password);
}
