package com.example.springboot.dto;

/**
 * @title:文章分类传输对象
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/12/16
 */
public class ArticleCategoryDto {
    //  tbl_article_category表基础字段
    private Long id;            // tbl_article_category表主键
    private Long categoryId;    // 分类信息ID
    private Long articleId;     // 文章ID

    // tbl_category_info表基础字段
    private String name;        // 分类信息显示名称
    private Byte number;        // 该分类下对应的文章数量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }
}
