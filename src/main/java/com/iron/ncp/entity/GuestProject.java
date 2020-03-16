package com.iron.ncp.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class GuestProject {
    @Id
    private Long id;

    private String name;

    private String company;

    private Long companyNum;

    private String idCard;

    private String address;

    private Long tel;

    private Date created;

    private Integer contact;

    private Integer contactHb;

    private Integer familyHealth;

    private Date visitTime;

    private Integer temp;

    private Long projectNum;

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