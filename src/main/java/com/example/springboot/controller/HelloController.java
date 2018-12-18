package com.example.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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
public class HelloController extends BaseController{

    @GetMapping("/hello")
    @ApiOperation("hello word")
    public String hello(){
        return "Hello Springboot!";
    }

}