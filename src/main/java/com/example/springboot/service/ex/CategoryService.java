package com.example.springboot.service.ex;

import com.example.springboot.dto.ArticleCategoryDto;
import com.example.springboot.entity.ArticleMessage;
import com.example.springboot.entity.Message;

import java.util.List;

/**
 * @title:
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/12/16
 */
public interface CategoryService {

    void addCategory(Message categoryInfo);

    void deleteCategoryById(Long id);

    void updateCategory(Message categoryInfo);

    void updateArticleCategory(ArticleMessage articleCategory);

    Message getOneById(Long id);

    List<Message> listAllCategory();

    ArticleCategoryDto getCategoryByArticleId(Long id);

}
