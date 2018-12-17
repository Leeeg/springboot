package com.example.springboot.service.impl;

import com.example.springboot.entity.SysLog;
import com.example.springboot.entity.SysView;
import com.example.springboot.service.ex.SysService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title:
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/12/16
 */
@Service
public class SystemServiceImpl implements SysService {
    @Override
    public void addLog(SysLog sysLog) {

    }

    @Override
    public void addView(SysView sysView) {

    }

    @Override
    public int getLogCount() {
        return 0;
    }

    @Override
    public int getViewCount() {
        return 0;
    }

    @Override
    public List<SysLog> listAllLog() {
        return null;
    }

    @Override
    public List<SysView> listAllView() {
        return null;
    }
}
