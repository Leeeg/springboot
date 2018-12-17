package com.example.springboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_article_info")
public class ArticleInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章简介，默认100个汉字以内
     */
    private String summary;

    /**
     * 文章是否置顶，0为否，1为是
     */
    @Column(name = "is_top")
    private Boolean isTop;

    /**
     * 文章访问量
     */
    private Integer traffic;

    /**
     * 创建时间
     */
    @Column(name = "create_by")
    private Date createBy;

    /**
     * 修改日期
     */
    @Column(name = "modified_by")
    private Date modifiedBy;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取文章简介，默认100个汉字以内
     *
     * @return summary - 文章简介，默认100个汉字以内
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置文章简介，默认100个汉字以内
     *
     * @param summary 文章简介，默认100个汉字以内
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 获取文章是否置顶，0为否，1为是
     *
     * @return is_top - 文章是否置顶，0为否，1为是
     */
    public Boolean getIsTop() {
        return isTop;
    }

    /**
     * 设置文章是否置顶，0为否，1为是
     *
     * @param isTop 文章是否置顶，0为否，1为是
     */
    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    /**
     * 获取文章访问量
     *
     * @return traffic - 文章访问量
     */
    public Integer getTraffic() {
        return traffic;
    }

    /**
     * 设置文章访问量
     *
     * @param traffic 文章访问量
     */
    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
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
     * 获取修改日期
     *
     * @return modified_by - 修改日期
     */
    public Date getModifiedBy() {
        return modifiedBy;
    }

    /**
     * 设置修改日期
     *
     * @param modifiedBy 修改日期
     */
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}