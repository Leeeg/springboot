package com.example.springboot.dao;

import com.example.springboot.entity.TblSortInfo;
import com.example.springboot.entity.TblSortInfoExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSortInfoMapper extends MyMapper<TblSortInfo> {
    long countByExample(TblSortInfoExample example);

    int deleteByExample(TblSortInfoExample example);

    List<TblSortInfo> selectByExample(TblSortInfoExample example);

    int updateByExampleSelective(@Param("record") TblSortInfo record, @Param("example") TblSortInfoExample example);

    int updateByExample(@Param("record") TblSortInfo record, @Param("example") TblSortInfoExample example);
}