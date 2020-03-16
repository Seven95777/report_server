package com.iron.ncp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Company {
    @Id
    private Long id;

    /**
     * 公司
     */
    private String company;

    /**
     * 入库时间
     */
    private Date created;

    /**
     * 公司编号
     */
    @Column(name = "company_num")
    private Long companyNum;

    /**
     * 公司层级
     */
    private Integer level;

    /**
     * 父级公司编号
     */
    @Column(name = "super_num")
    private Long superNum;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 其他区域
     */
    private String area;

    /**
     * 是否境外0否1是
     */
    private Integer outsideFlag;

    /**
     * 描述
     */
    private String description;
}