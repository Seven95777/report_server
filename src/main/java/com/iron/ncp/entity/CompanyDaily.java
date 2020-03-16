package com.iron.ncp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iron.ncp.utils.CommonUtils;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class CompanyDaily {
    @Id
    private Long id;

    private String company;

    private Date created;

    @JsonFormat(pattern = CommonUtils.DATE)
    private Date entryTime;

    private Long companyNum;

    private Integer reworkFlag;

    private Integer staffCount;

    private Integer companyStatus;

    @Transient
    private String srcTable;

    @Transient
    private Integer subFlag = 0;

    /**
     * 清空标记
     */
    @Transient
    private Long delNum;

    private Integer reworkCount;

    private Integer dutyCount;

    private Integer operateCount;

    /**
     * sum（全员上班人数，值班数，未中断经营员工数）
     */
    private Integer reworkSum;

    /**
     * 父级公司编号
     */
    @Transient
    private Long superNum;

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

    //父级公司名字
    @Transient
    private String SuperName;
}