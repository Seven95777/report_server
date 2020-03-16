package com.iron.ncp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iron.ncp.utils.CommonUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class StaffInfo {
    @Id
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 公司
     */
    private String company;

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
     * 联系方式
     */
    private Long tel;

    /**
     * 入库时间
     */
    private Date created;

    /**
     * 录入日期
     */
    @JsonFormat(pattern = CommonUtils.DATE)
    private Date entryTime;

    /**
     * 体温 0正常；1异常
     */
    private Integer temp;

    /**
     * 部门名称
     */
    private String depart;

    /**
     * 公司编号
     */
    @Column(name = "company_num")
    private Long companyNum;

    @Transient
    private String srcTable;

    @Transient
    private Integer subFlag = 0;

    /**
     * 清空标记
     */
    @Transient
    private Long delNum;

    /**
     * 是否复工0否1是
     */
    private Integer reworkFlag;
}