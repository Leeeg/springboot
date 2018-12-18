package com.example.springboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_article_content")
public class TblArticleContent {
    private Long id;

    private String content;

    /**
     * 对应文章ID
     */
    @Column(name = "article_id")
    private Long articleId;

    /**
     * 创建时间
     */
    @Column(name = "create_by")
    private Date createBy;

    /**
     * 更新时间
     */
    @Column(name = "modifield_by")
    private Date modifieldBy;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取对应文章ID
     *
     * @return article_id - 对应文章ID
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置对应文章ID
     *
     * @param articleId 对应文章ID
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取创建时间
     *
     * @return create_by - 创建时间
     */
    public Date getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建时间
     *
     * @param createBy 创建时间
     */
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取更新时间
     *
     * @return modifield_by - 更新时间
     */
    public Date getModifieldBy() {
        return modifieldBy;
    }

    /**
     * 设置更新时间
     *
     * @param modifieldBy 更新时间
     */
    public void setModifieldBy(Date modifieldBy) {
        this.modifieldBy = modifieldBy;
    }
}