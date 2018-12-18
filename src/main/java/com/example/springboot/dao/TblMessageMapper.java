package com.example.springboot.dao;

import com.example.springboot.entity.TblMessage;
import com.example.springboot.entity.TblMessageExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblMessageMapper extends MyMapper<TblMessage> {
    long countByExample(TblMessageExample example);

    int deleteByExample(TblMessageExample example);

    List<TblMessage> selectByExample(TblMessageExample example);

    int updateByExampleSelective(@Param("record") TblMessage record, @Param("example") TblMessageExample example);

    int updateByExample(@Param("record") TblMessage record, @Param("example") TblMessageExample example);
}