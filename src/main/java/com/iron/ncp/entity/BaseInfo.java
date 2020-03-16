package com.iron.ncp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class BaseInfo {
    @Id
    private Long id;

    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不得为空")
    private String name;

    /**
     * 公司
     */
    private String company;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 目前居住地
     */
    private String address;

    /**
     * 联系方式
     */
    @NotEmpty(message = "手机号不得为空")
    private Long tel;

    /**
     * 入库时间
     */
    private Date created;

    /**
     * 部门名称
     */
    private String depart;

    /**
     * 人员类别 0集团内部；1访客
     */
    @Column(name = "person_type")
    private Integer personType;

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
     * 家人情况0无；1有
     */
    @Column(name = "family_health")
    private Integer familyHealth;

    /**
     * 公司编号
     */
    @Column(name = "company_num")
    private Long companyNum;

    @Transient
    private Integer subFlag = 0;

    /**
     * 清空标记
     */
    @Transient
    private Long delNum;
}