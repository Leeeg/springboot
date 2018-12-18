package com.example.springboot.dao;

import com.example.springboot.entity.TblArticleContent;
import com.example.springboot.entity.TblArticleContentExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblArticleContentMapper extends MyMapper<TblArticleContent> {
    long countByExample(TblArticleContentExample example);

    int deleteByExample(TblArticleContentExample example);

    List<TblArticleContent> selectByExample(TblArticleContentExample example);

    int updateByExampleSelective(@Param("record") TblArticleContent record, @Param("example") TblArticleContentExample example);

    int updateByExample(@Param("record") TblArticleContent record, @Param("example") TblArticleContentExample example);
}