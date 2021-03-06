package com.example.springboot.service.impl;

import com.example.springboot.dao.VisitLogMapper;
import com.example.springboot.entity.VisitLog;
import com.example.springboot.service.BaseService;
import com.example.springboot.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-19
 * @Time 下午7:35
 */
@Service
public class VisitServiceImpl extends BaseService<VisitLog> implements VisitService {

    @Autowired
    private VisitLogMapper logMapper;

    public void addVisitLog(VisitLog visitLog) {
        save(visitLog);
    }

    public List<VisitLog> getAllVisitLog() {
        return logMapper.selectAll();
    }
}
