package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "v_account")
public class Account implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户Id
     */
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 用户Name
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 用户性别 0表示女
     */
    @Column(name = "account_sex")
    private Boolean accountSex;

    /**
     * 用户注册时间
     */
    @Column(name = "account_create_time")
    private Date accountCreateTime;

    /**
     * 用户最后登陆时间
     */
    @Column(name = "account_login_time")
    private Date accountLoginTime;

    /**
     * 用户头像url
     */
    @Column(name = "acount_icon")
    private String acountIcon;

    private static final long serialVersionUID = 1L;

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
     * 获取用户Id
     *
     * @return account_id - 用户Id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 设置用户Id
     *
     * @param accountId 用户Id
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取用户Name
     *
     * @return account_name - 用户Name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置用户Name
     *
     * @param accountName 用户Name
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * 获取用户性别 0表示女
     *
     * @return account_sex - 用户性别 0表示女
     */
    public Boolean getAccountSex() {
        return accountSex;
    }

    /**
     * 设置用户性别 0表示女
     *
     * @param accountSex 用户性别 0表示女
     */
    public void setAccountSex(Boolean accountSex) {
        this.accountSex = accountSex;
    }

    /**
     * 获取用户注册时间
     *
     * @return account_create_time - 用户注册时间
     */
    public Date getAccountCreateTime() {
        return accountCreateTime;
    }

    /**
     * 设置用户注册时间
     *
     * @param accountCreateTime 用户注册时间
     */
    public void setAccountCreateTime(Date accountCreateTime) {
        this.accountCreateTime = accountCreateTime;
    }

    /**
     * 获取用户最后登陆时间
     *
     * @return account_login_time - 用户最后登陆时间
     */
    public Date getAccountLoginTime() {
        return accountLoginTime;
    }

    /**
     * 设置用户最后登陆时间
     *
     * @param accountLoginTime 用户最后登陆时间
     */
    public void setAccountLoginTime(Date accountLoginTime) {
        this.accountLoginTime = accountLoginTime;
    }

    /**
     * 获取用户头像url
     *
     * @return acount_icon - 用户头像url
     */
    public String getAcountIcon() {
        return acountIcon;
    }

    /**
     * 设置用户头像url
     *
     * @param acountIcon 用户头像url
     */
    public void setAcountIcon(String acountIcon) {
        this.acountIcon = acountIcon == null ? null : acountIcon.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", accountName=").append(accountName);
        sb.append(", accountSex=").append(accountSex);
        sb.append(", accountCreateTime=").append(accountCreateTime);
        sb.append(", accountLoginTime=").append(accountLoginTime);
        sb.append(", acountIcon=").append(acountIcon);
        sb.append("]");
        return sb.toString();
    }
}