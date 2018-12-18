package com.example.springboot.dao;

import com.example.springboot.entity.SysLog;
import com.example.springboot.entity.SysLogExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogMapper extends MyMapper<SysLog> {
    long countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    List<SysLog> selectByExample(SysLogExample example);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);
}