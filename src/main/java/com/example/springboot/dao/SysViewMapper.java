package com.example.springboot.dao;

import com.example.springboot.entity.SysView;
import com.example.springboot.entity.SysViewExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysViewMapper extends MyMapper<SysView> {
    long countByExample(SysViewExample example);

    int deleteByExample(SysViewExample example);

    List<SysView> selectByExample(SysViewExample example);

    int updateByExampleSelective(@Param("record") SysView record, @Param("example") SysViewExample example);

    int updateByExample(@Param("record") SysView record, @Param("example") SysViewExample example);
}