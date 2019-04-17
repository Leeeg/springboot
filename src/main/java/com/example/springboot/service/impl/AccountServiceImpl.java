package com.example.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.common.entity.SendSmsEntity;
import com.example.springboot.dao.AccountMapper;
import com.example.springboot.entity.Account;
import com.example.springboot.service.AccountService;
import com.example.springboot.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import tk.mybatis.mapper.entity.Example;

import java.net.URI;

import static com.example.springboot.common.Container.SMS_APPCODE;
import static com.example.springboot.common.Container.SMS_HOST;
import static com.example.springboot.common.Container.SMS_TPL_ID;

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

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Integer getCode(String phoneNumber, String code) {
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("accountPhone", phoneNumber);
        int count = accountMapper.selectCountByExample(example);
        if (count > 0) {//已注册
            return 2;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "APPCODE " + SMS_APPCODE);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("mobile", phoneNumber);
        body.add("param", "code:" + code);
        body.add("tpl_id", SMS_TPL_ID);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(SMS_HOST, requestEntity, String.class);
        logger.info("getCode : response = " + response.toString());
        if (200 != response.getStatusCodeValue()) {
            return -1;
        }
        if (null == response.getBody() || !response.getBody().contains("00000")) {
            return -2;
        }
        logger.info("getCode : body = " + response.getBody());
        return 1;
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
