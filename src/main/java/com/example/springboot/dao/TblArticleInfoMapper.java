package com.example.springboot.dao;

import com.example.springboot.entity.TblArticleInfo;
import com.example.springboot.entity.TblArticleInfoExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblArticleInfoMapper extends MyMapper<TblArticleInfo> {
    long countByExample(TblArticleInfoExample example);

    int deleteByExample(TblArticleInfoExample example);

    List<TblArticleInfo> selectByExample(TblArticleInfoExample example);

    int updateByExampleSelective(@Param("record") TblArticleInfo record, @Param("example") TblArticleInfoExample example);

    int updateByExample(@Param("record") TblArticleInfo record, @Param("example") TblArticleInfoExample example);
}