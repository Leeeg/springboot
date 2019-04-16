package com.example.springboot.service.impl;

import com.example.springboot.controller.AccountController;
import com.example.springboot.entity.Account;
import com.example.springboot.service.AccountService;
import com.example.springboot.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.example.springboot.common.Container.SMS_APPCODE;
import static com.example.springboot.common.Container.SMS_HOST;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 19-4-16
 * @Time 下午3:45
 */
@Service
public class AccountServiceImpl extends BaseService<Account> implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Integer getCode(String phoneNumber) {

        getWeather();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "APPCODE " + SMS_APPCODE);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("mobile", phoneNumber);
        body.add("param", "code:1234");
        body.add("tpl_id", "TP1711063");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(SMS_HOST, requestEntity, String.class);
        logger.info("getCode : body = " + response.toString());
        return null;
    }

    private void getWeather() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                "http://v.juhe.cn/weather/index?cityname={cityname}&dtype={dtype}&format={format}&key={key}")
                .build()
                .expand("深圳", "json", "1", "f3ad4c0279fbcc4f43ced93812171eaa")
                .encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        int code = response.getStatusCodeValue();
        logger.info("getWeather : code = " + code);
        logger.info("getWeather : response = " + response.toString());


    }
}
