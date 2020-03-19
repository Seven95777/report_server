package com.iron.ncp.task;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Description:
 * User: PengXJ
 * Date: 2020/2/11
 */
@Slf4j
@Component
public class DataTask {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    /**
     * 动态生成表-每天23点生成第二天的表
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void startCreate() throws SQLException {
        //加一天，第二天的表
        DateTime dateTime = new DateTime();
        DateTime plusDate = dateTime.plusDays(1);
        String srcDay = plusDate.toString("yyyyMMdd");
        createTable(srcDay);
    }

    /**
     * 启动时判断今天的表
     */
    @PostConstruct
    public void createStartTable() throws SQLException {
        log.warn("today create init");
        DateTime dateTime = new DateTime();
        String srcDay = dateTime.toString("yyyyMMdd");
        createTable(srcDay);
    }

    /**
     * 创建人员表
     * @param srcDay
     * @throws SQLException
     */
    public void createTable(String srcDay) throws SQLException {
        log.warn("info{} table create",srcDay);
        Statement sm = null;
        Connection con = null;
        try {
            //建立连接
            con = DriverManager.getConnection(url, username, password);
            //创建对象
            sm = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //执行数据库表的创建操作
        sm.execute("CREATE TABLE IF NOT EXISTS `guest_info"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL COMMENT '姓名',\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '访客所属公司',\n" +
                "  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',\n" +
                "  `address` varchar(255) DEFAULT NULL COMMENT '目前居住地',\n" +
                "  `tel` bigint(50) DEFAULT NULL COMMENT '联系方式',\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `contact` int(5) DEFAULT NULL COMMENT '14天有无接触 0无；1有',\n" +
                "  `contact_hb` int(5) DEFAULT NULL COMMENT '14天有无关联湖北等高发地 0无；1有',\n" +
                "  `family_health` int(5) DEFAULT NULL COMMENT '家人情况0无；1有',\n" +
                "  `visit_time` datetime DEFAULT NULL COMMENT '到访日期',\n" +
                "  `temp` int(5) DEFAULT NULL COMMENT '体温 0正常；1异常',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '目的地公司编号',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
                "CREATE TABLE IF NOT EXISTS `not_rework_impt"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `entry_time` date DEFAULT NULL COMMENT '录入日期',\n" +
                "  `name` varchar(255) DEFAULT NULL COMMENT '人员姓名',\n" +
                "  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',\n" +
                "  `address` varchar(255) DEFAULT NULL COMMENT '目前居住地',\n" +
                "  `sex` int(2) DEFAULT NULL COMMENT '0女1男',\n" +
                "  `age` int(5) DEFAULT NULL COMMENT '年龄',\n" +
                "  `tel` bigint(50) DEFAULT NULL COMMENT '联系方式',\n" +
                "  `direction` varchar(255) DEFAULT NULL COMMENT '当天外出去向',\n" +
                "  `direction_way` int(5) DEFAULT NULL COMMENT '外出方式',\n" +
                "  `leave_back_time` varchar(255) DEFAULT NULL COMMENT '何时离开或返回本公司所在地',\n" +
                "  `health` int(10) DEFAULT NULL COMMENT '症状0：正常 1：发热 2：乏力 3：咳嗽',\n" +
                "  `contact_hb` int(2) DEFAULT NULL COMMENT '是否接触湖北省人员0无1有',\n" +
                "  `contact_ncp` int(2) DEFAULT NULL COMMENT '是否与确诊疑似接触0无1有',\n" +
                "  `pass_hb` int(2) DEFAULT NULL COMMENT '是否经过湖北省0无1有',\n" +
                "  `isolation` int(2) DEFAULT NULL COMMENT '是否隔离',\n" +
                "  `ob_result` int(2) DEFAULT NULL COMMENT '观察结果0疑似1确诊2死亡',\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '填报单位',\n" +
                "  `edit_name` varchar(255) DEFAULT NULL COMMENT '填报者姓名',\n" +
                "  `edit_time` date DEFAULT NULL COMMENT '填报日期',\n" +
                "  `edit_tel` bigint(50) DEFAULT NULL COMMENT '填报人电话',\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '公司编号',\n" +
                "  `back_cd` varchar(255) DEFAULT NULL COMMENT '何时从何地回蓉（武汉等高发疫情地区）',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
                "CREATE TABLE IF NOT EXISTS `not_rework_info"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `entry_time` date DEFAULT NULL COMMENT '录入日期',\n" +
                "  `name` varchar(255) DEFAULT NULL COMMENT '人员姓名',\n" +
                "  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',\n" +
                "  `address` varchar(255) DEFAULT NULL COMMENT '目前居住地',\n" +
                "  `sex` int(2) DEFAULT NULL COMMENT '0女1男',\n" +
                "  `age` int(5) DEFAULT NULL COMMENT '年龄',\n" +
                "  `tel` bigint(50) DEFAULT NULL COMMENT '联系方式',\n" +
                "  `direction` varchar(255) DEFAULT NULL COMMENT '当天外出去向',\n" +
                "  `direction_way` int(5) DEFAULT NULL COMMENT '外出方式',\n" +
                "  `leave_back_time` varchar(255) DEFAULT NULL COMMENT '何时离开或返回本公司所在地',\n" +
                "  `health` int(10) DEFAULT NULL COMMENT '症状0：正常 1：发热 2：乏力 3：咳嗽',\n" +
                "  `contact_hb` int(2) DEFAULT NULL COMMENT '是否接触湖北省人员0无1有',\n" +
                "  `contact_ncp` int(2) DEFAULT NULL COMMENT '是否与确诊疑似接触0无1有',\n" +
                "  `pass_hb` int(2) DEFAULT NULL COMMENT '是否经过湖北省0无1有',\n" +
                "  `isolation` int(2) DEFAULT NULL COMMENT '是否隔离',\n" +
                "  `ob_result` int(2) DEFAULT NULL COMMENT '观察结果0疑似1确诊2死亡',\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '填报单位',\n" +
                "  `edit_name` varchar(255) DEFAULT NULL COMMENT '填报者姓名',\n" +
                "  `edit_time` date DEFAULT NULL COMMENT '填报日期',\n" +
                "  `edit_tel` bigint(50) DEFAULT NULL COMMENT '填报人电话',\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '公司编号',\n" +
                "  `back_cd` varchar(255) DEFAULT NULL COMMENT '何时从何地回蓉（武汉等高发疫情地区）',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
                "CREATE TABLE IF NOT EXISTS `project"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `entry_time` date DEFAULT NULL COMMENT '录入日期',\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '公司',\n" +
                "  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',\n" +
                "  `name` varchar(255) DEFAULT NULL COMMENT '人员姓名',\n" +
                "  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',\n" +
                "  `address` varchar(255) DEFAULT NULL COMMENT '目前居住地',\n" +
                "  `contact` int(5) DEFAULT NULL COMMENT '14天有无接触 0无；1有',\n" +
                "  `contact_hb` int(5) DEFAULT NULL COMMENT '14天有无关联湖北等高发地 0无；1有',\n" +
                "  `temp` int(5) DEFAULT NULL COMMENT '体温 0正常；1异常',\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `from_addr` varchar(255) DEFAULT NULL COMMENT '来源地',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '公司编号',\n" +
                "  `impt_flag` int(2) DEFAULT NULL COMMENT '是否重点项目0否1是',\n" +
                "  `tel` bigint(50) DEFAULT NULL COMMENT '联系方式',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目员工表';" +
                "CREATE TABLE IF NOT EXISTS `staff_info"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL COMMENT '姓名',\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '公司',\n" +
                "  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',\n" +
                "  `address` varchar(255) DEFAULT NULL COMMENT '目前居住地',\n" +
                "  `tel` bigint(50) DEFAULT NULL COMMENT '联系方式',\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `entry_time` date DEFAULT NULL COMMENT '录入日期',\n" +
                "  `temp` int(5) DEFAULT NULL COMMENT '体温 0正常；1异常',\n" +
                "  `depart` varchar(255) DEFAULT NULL COMMENT '部门名称',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '公司编号'," +
                "  `rework_flag` int(2) DEFAULT NULL COMMENT '员工是否复工0否1是',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业(公司)员工表';" +
                "CREATE TABLE IF NOT EXISTS `project_daily"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `project_num` bigint(20) DEFAULT NULL COMMENT '目的地项目编号',\n" +
                "  `entry_time` date DEFAULT NULL COMMENT '录入日期',\n" +
                "  `impt_flag` int(2) DEFAULT NULL COMMENT '是否重点项目0否1是',\n" +
                "  `rework_flag` int(2) DEFAULT NULL COMMENT '是否复工0否1是',\n" +
                "  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',\n" +
                "  `people_count` int(10) DEFAULT NULL COMMENT '项目总人数',\n" +
                "  `rework_count` int(10) DEFAULT NULL COMMENT '项目复工人数',\n" +
                "  `abnormal_count` varchar(255) DEFAULT NULL COMMENT '异常人数',\n" +
                "  `outside_flag` int(2) DEFAULT NULL COMMENT '是否境外0否1是',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '公司编号',\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '公司',\n" +
                "  `worker_count` int(11) DEFAULT NULL COMMENT '劳务人员总数',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
                "CREATE TABLE IF NOT EXISTS `guest_project"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL COMMENT '姓名',\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '访客所属公司',\n" +
                "  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',\n" +
                "  `address` varchar(255) DEFAULT NULL COMMENT '目前居住地',\n" +
                "  `tel` bigint(50) DEFAULT NULL COMMENT '联系方式',\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `contact` int(5) DEFAULT NULL COMMENT '14天有无接触 0无；1有',\n" +
                "  `contact_hb` int(5) DEFAULT NULL COMMENT '14天有无关联湖北等高发地 0无；1有',\n" +
                "  `family_health` int(5) DEFAULT NULL COMMENT '家人情况0无；1有',\n" +
                "  `visit_time` datetime DEFAULT NULL COMMENT '到访日期',\n" +
                "  `temp` int(5) DEFAULT NULL COMMENT '体温 0正常；1异常',\n" +
                "  `project_num` bigint(20) DEFAULT NULL COMMENT '目的地项目编号',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '公司编号',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
                "CREATE TABLE IF NOT EXISTS `company_daily"+srcDay+"` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `company` varchar(255) DEFAULT NULL COMMENT '公司',\n" +
                "  `created` datetime DEFAULT NULL COMMENT '入库时间',\n" +
                "  `entry_time` date DEFAULT NULL COMMENT '录入日期',\n" +
                "  `company_num` bigint(20) DEFAULT NULL COMMENT '公司编号',\n" +
                "  `rework_flag` int(2) DEFAULT NULL COMMENT '企业是否复工0否1是 不在WEB 端展示',\n" +
                "  `staff_count` int(10) DEFAULT NULL COMMENT '员工数',\n" +
                "  `company_status` int(2) DEFAULT NULL COMMENT '0 一直运营 1已完全复工 2已部分复工 3未复工 4 未直接生产经营',\n" +
                "  `rework_count` int(10) DEFAULT NULL COMMENT '复工人数',\n" +
                "  `duty_count` int(10) DEFAULT NULL COMMENT '值班人数',\n" +
                "  `operate_count` int(11) DEFAULT NULL COMMENT '未中断经营员工数',\n" +
                "  `rework_sum` int(11) DEFAULT NULL COMMENT 'sum（全员上班人数，值班数，未中断经营员工数）',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
        sm.close();
        con.close();
    }


}

