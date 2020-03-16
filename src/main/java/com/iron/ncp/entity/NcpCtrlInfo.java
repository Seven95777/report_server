package com.iron.ncp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iron.ncp.utils.CommonUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class NcpCtrlInfo {
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
     * 上班员工总人数
     */
    @Column(name = "work_count")
    private Integer workCount;

    /**
     * 上班一线员工总人数
     */
    @Column(name = "first_work_count")
    private Integer firstWorkCount;

    /**
     * 有无接待湖北游客定点酒店0无1有
     */
    @Column(name = "appoint_hotel")
    private Integer appointHotel;

    /**
     * 酒店有无确诊入住0无1有
     */
    @Column(name = "hotel_comfirm")
    private Integer hotelComfirm;

    /**
     * 防疫宣传次数
     */
    @Column(name = "pub_count")
    private Integer pubCount;

    /**
     * 公共区域消毒次数
     */
    @Column(name = "dis_count")
    private Integer disCount;

    /**
     * 医疗检测点个数
     */
    @Column(name = "check_point_count")
    private Integer checkPointCount;

    /**
     * 值班人数
     */
    @Column(name = "duty_count")
    private Integer dutyCount;

    /**
     * 防疫共投入资金
     */
    private Integer cost;

    /**
     * 已使用口罩数
     */
    @Column(name = "used_mask")
    private Integer usedMask;

    /**
     * 已使用手套
     */
    @Column(name = "used_glove")
    private Integer usedGlove;

    /**
     * 已使用温度计
     */
    @Column(name = "used_ther")
    private Integer usedTher;

    /**
     * 已使用酒精
     */
    @Column(name = "used_alcohol")
    private Integer usedAlcohol;

    /**
     * 已使用消毒液
     */
    @Column(name = "used_dis")
    private Integer usedDis;

    /**
     * 已使用防护服
     */
    @Column(name = "used_clothing")
    private Integer usedClothing;

    /**
     * 库存口罩数
     */
    @Column(name = "stock_mask")
    private Integer stockMask;

    /**
     * 库存手套
     */
    @Column(name = "stock_glove")
    private Integer stockGlove;

    /**
     * 库存温度计
     */
    @Column(name = "stock_ther")
    private Integer stockTher;

    /**
     * 库存酒精
     */
    @Column(name = "stock_alcohol")
    private Integer stockAlcohol;

    /**
     * 库存消毒液
     */
    @Column(name = "stock_dis")
    private Integer stockDis;

    /**
     * 库存防护服
     */
    @Column(name = "stock_clothing")
    private Integer stockClothing;

    /**
     * 需要集团解决的问题
     */
    @Column(name = "need_solved")
    private String needSolved;

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