package com.iron.ncp.entity;

import lombok.Data;

import java.util.Date;


/**
 * Weather
 *
 * @author PengXJ
 * @version 2.0
 * @date 2020/3/13 16:51
 **/
@Data
//@TableName(value = "weather")
public class Weather {

    private Long id;
    //地区
    private String area;
    //温度
    private Float temp;
    //湿度
    private String humidity;
    //pm
    private Float pm25;
    //风级
    private String fl;
    //最低温度
    private Float lowTp;
    //最高温度
    private Float highTp;
    //天气
    private String weatherType;

    private Date created;

}
