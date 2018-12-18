package com.example.springboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_view")
public class SysView {
    private Long id;

    /**
     * 访问IP
     */
    private String ip;

    /**
     * 访问时间
     */
    @Column(name = "create_by")
    private Date createBy;

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
     * 获取访问IP
     *
     * @return ip - 访问IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置访问IP
     *
     * @param ip 访问IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取访问时间
     *
     * @return create_by - 访问时间
     */
    public Date getCreateBy() {
        return createBy;
    }

    /**
     * 设置访问时间
     *
     * @param createBy 访问时间
     */
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }
}