package com.example.springboot.dto;

/**
 * @title:文章评论信息
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/12/16
 */
public class ArticleCommentDto {
    // tbl_comment基础字段
    private Long id;                // 评论id
    private String content;         // 评论内容
    private String name;            // 用户自定义的显示名称
    private String email;
    private String ip;

    // tbl_article_comment基础字段
    private Long articleCommentId;  // tbl_article_comment主键
    private Long articleId;         // 文章ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(Long articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
