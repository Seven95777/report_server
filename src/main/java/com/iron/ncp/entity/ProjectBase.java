package com.iron.ncp.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class ProjectBase {
    @Id
    private Long id;

    private String projectName;

    private Long companyNum;

    private String company;

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

    private Long projectNum;

    private Date created;

    @Transient
    private Integer subFlag = 0;

    /**
     * 清空标记
     */
    @Transient
    private Long delNum;

    /**
     * 父级项目编号
     */
    private Long superProjectNum;

    /**
     * 项目层级
     */
    private Integer level;

    /**
     * 是否境外0否1是
     */
    private Integer outsideFlag;

    private Integer imptFlag;

    @Transient
    private String username;

    @Transient
    private String password;

    @Transient
    private Integer workerCount;
    @Transient
    private Integer peopleCount;
    @Transient
    private Integer reworkCount;
    @Transient
    private Integer reworkFlag;
}