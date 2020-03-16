package com.iron.ncp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iron.ncp.utils.CommonUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class NotReworkImpt {
    @Id
    private Long id;

    /**
     * 录入日期
     */
    @JsonFormat(pattern = CommonUtils.DATE)
    private Date entryTime;

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
     * 0女1男
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系方式
     */
    private Long tel;

    /**
     * 当天外出去向
     */
    private String direction;

    /**
     * 外出方式
     */
    @Column(name = "direction_way")
    private Integer directionWay;

    /**
     * 何时离开或返回本公司所在地
     */
    private String leaveBackTime;

    /**
     * 症状0：正常 1：发热 2：乏力 3：咳嗽
     */
    private Integer health;

    /**
     * 是否接触湖北省人员0无1有
     */
    @Column(name = "contact_hb")
    private Integer contactHb;

    /**
     * 是否与确诊疑似接触0无1有
     */
    @Column(name = "contact_ncp")
    private Integer contactNcp;

    /**
     * 是否经过湖北省0无1有
     */
    @Column(name = "pass_hb")
    private Integer passHb;

    /**
     * 是否隔离
     */
    private Integer isolation;

    /**
     * 观察结果0疑似1确诊2死亡
     */
    @Column(name = "ob_result")
    private Integer obResult;

    /**
     * 填报单位
     */
    private String company;

    /**
     * 填报者姓名
     */
    @Column(name = "edit_name")
    private String editName;

    /**
     * 填报日期
     */
    @JsonFormat(pattern = CommonUtils.DATE)
    private Date editTime;

    /**
     * 填报人电话
     */
    @Column(name = "edit_tel")
    private Long editTel;

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
     * 何时从何地回蓉（武汉等高发疫情地区）
     */
    private String backCd;

    @Transient
    private String srcTable;

    @Transient
    private Integer subFlag = 0;

    /**
     * 清空标记
     */
    @Transient
    private Long delNum;
}