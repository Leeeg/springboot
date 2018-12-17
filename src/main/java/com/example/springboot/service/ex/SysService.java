package com.example.springboot.service.ex;

import com.example.springboot.entity.SysLog;
import com.example.springboot.entity.SysView;

import java.util.List;

/**
 * @title:日志/访问统计等系统相关Service
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/12/16
 */
public interface SysService {
    void addLog(SysLog sysLog);

    void addView(SysView sysView);

    int getLogCount();

    int getViewCount();

    List<SysLog> listAllLog();

    List<SysView> listAllView();

}
