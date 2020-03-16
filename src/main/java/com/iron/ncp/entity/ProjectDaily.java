package com.iron.ncp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iron.ncp.utils.CommonUtils;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class ProjectDaily {
    @Id
    private Long id;

    private Date created;

    private Long projectNum;

    private Long companyNum;

    private String company;

    @JsonFormat(pattern = CommonUtils.DATE)
    private Date entryTime;

    private Integer imptFlag;

    private Integer reworkFlag;

    private String projectName;

    private Integer peopleCount;

    private Integer reworkCount;

    private String abnormalCount;

    private Integer outsideFlag;

    @Transient
    private String srcTable;

    @Transient
    private Integer subFlag = 0;

    /**
     * 清空标记
     */
    @Transient
    private Long delNum;

    private Integer workerCount;

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
    private String username;

    /**
     * 密码
     */
    @Transient
    private String password;
}