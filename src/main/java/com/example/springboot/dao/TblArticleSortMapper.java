package com.example.springboot.dao;

import com.example.springboot.entity.TblArticleSort;
import com.example.springboot.entity.TblArticleSortExample;
import com.example.springboot.util.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblArticleSortMapper extends MyMapper<TblArticleSort> {
    long countByExample(TblArticleSortExample example);

    int deleteByExample(TblArticleSortExample example);

    List<TblArticleSort> selectByExample(TblArticleSortExample example);

    int updateByExampleSelective(@Param("record") TblArticleSort record, @Param("example") TblArticleSortExample example);

    int updateByExample(@Param("record") TblArticleSort record, @Param("example") TblArticleSortExample example);
}