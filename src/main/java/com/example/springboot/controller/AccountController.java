package com.example.springboot.controller;

import com.example.springboot.controller.presenter.AccountPresenter;
import com.example.springboot.dto.Response;
import com.example.springboot.service.AccountService;
import com.example.springboot.service.BlogService;
import com.example.springboot.util.response.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title:
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/11/9
 */
@RestController
@RequestMapping("/api/main")
@Api(value = "/account", tags = "Account", description = "帐号操作")
public class AccountController extends BaseController implements AccountPresenter {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @ApiOperation("登陆")
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @Override
    public Response login(String userName, String password) {

        return null;
    }

    @ApiOperation("获取验证码")
    @PostMapping("/getCode")
    @ApiImplicitParam(name = "phoneNumber", value = "手机号", required = true, dataType = "String")
    @Override
    public Response getCode(String phoneNumber) {
        logger.info("getCode : " + phoneNumber);
        accountService.getCode(phoneNumber);
        return ResponseUtil.success(null);
    }

}
