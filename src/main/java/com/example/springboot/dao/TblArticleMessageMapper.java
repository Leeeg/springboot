package com.example.springboot.dao;

import com.example.springboot.entity.TblArticleMessage;
import com.example.springboot.entity.TblArticleMessageExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblArticleMessageMapper extends MyMapper<TblArticleMessage> {
    long countByExample(TblArticleMessageExample example);

    int deleteByExample(TblArticleMessageExample example);

    List<TblArticleMessage> selectByExample(TblArticleMessageExample example);

    int updateByExampleSelective(@Param("record") TblArticleMessage record, @Param("example") TblArticleMessageExample example);

    int updateByExample(@Param("record") TblArticleMessage record, @Param("example") TblArticleMessageExample example);
}