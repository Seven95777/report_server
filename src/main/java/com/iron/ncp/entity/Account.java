package com.iron.ncp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class Account {
    @Id
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 入库日期
     */
    private Date created;

    /**
     * 账户类型
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 填报人姓名
     */
    @Column(name = "edit_name")
    private String editName;

    /**
     * 填报人联系方式
     */
    @Column(name = "edit_tel")
    private Long editTel;

    /**
     * 公司编号
     */
    @Column(name = "company_num")
    private Long companyNum;

    private String projectName;

    private Long projectNum;

    private Integer auth;

    /**
     * 省
     */
    @Transient
    private String province;

    /**
     * 市
     */
    @Transient
    private String city;

    /**
     * 其他区域
     */
    @Transient
    private String area;

    @Transient
    private Integer imptFlag;
}