package com.iron.ncp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iron.ncp.utils.CommonUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class HighBack {
    @Id
    private Long id;

    /**
     * 录入日期
     */
    @JsonFormat(pattern = CommonUtils.DATE)
    private Date entryTime;

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
     * 武汉等高发疫区回蓉人数
     */
    @Column(name = "high_back_count")
    private Integer highBackCount;

    /**
     * 隔离人数
     */
    @Column(name = "isolation_count")
    private Integer isolationCount;

    /**
     * 疑似人数
     */
    @Column(name = "suspect_count")
    private Integer suspectCount;

    /**
     * 确诊人数
     */
    @Column(name = "comfirm_count")
    private Integer comfirmCount;

    /**
     * 死亡人数
     */
    @Column(name = "dead_count")
    private Integer deadCount;

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