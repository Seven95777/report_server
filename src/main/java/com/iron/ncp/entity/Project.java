package com.iron.ncp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iron.ncp.utils.CommonUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class Project {
    @Id
    private Long id;

    /**
     * 录入日期
     */
    @JsonFormat(pattern = CommonUtils.DATE)
    private Date entryTime;

    /**
     * 公司
     */
    private String company;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;


    /**
     * 人员姓名
     */
    private String name;

    /**
     * 身份证
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 目前居住地
     */
    private String address;

    /**
     * 14天有无接触 0无；1有
     */
    private Integer contact;

    /**
     * 14天有无关联湖北等高发地 0无；1有
     */
    @Column(name = "contact_hb")
    private Integer contactHb;

    /**
     * 体温 0正常；1异常
     */
    private Integer temp;

    /**
     * 入库时间
     */
    private Date created;

    /**
     * 来源地
     */
    @Column(name = "from_addr")
    private String fromAddr;

    /**
     * 公司编号
     */
    @Column(name = "company_num")
    private Long companyNum;

    /**
     * 是否重点项目0否1是
     */
    @Column(name = "impt_flag")
    private Integer imptFlag;

    @Transient
    private String srcTable;

    @Transient
    private Integer subFlag = 0;

    /**
     * 联系方式
     */
    private Long tel;

    /**
     * 清空标记
     */
    @Transient
    private Long delNum;

}