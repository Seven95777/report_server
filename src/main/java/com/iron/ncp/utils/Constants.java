package com.iron.ncp.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: PengXJ
 * Date: 2020/2/17
 */
public abstract class Constants {

    //复工情况
    public static final Map<Integer, String> REWORK_MAP = new HashMap<>();
    //出勤状态
    public static final Map<Integer, String> ATTENDANCE_MAP = new HashMap<>();
    //居住情况
    public static final Map<Integer, String> CONDITION_MAP = new HashMap<>();
    //交通方式
    public static final Map<Integer, String> TRAFFIC_MAP = new HashMap<>();

    static {
        REWORK_MAP.put(0, "一直运营");
        REWORK_MAP.put(1, "完全复工");
        REWORK_MAP.put(2, "部分复工");
        REWORK_MAP.put(3, "未复工");

        ATTENDANCE_MAP.put(0, "公司办公");
        ATTENDANCE_MAP.put(1, "在家办公");
        ATTENDANCE_MAP.put(2, "项目现场");
        ATTENDANCE_MAP.put(3, "出差");
        ATTENDANCE_MAP.put(4, "休假");

        CONDITION_MAP.put(0, "在家居住");
        CONDITION_MAP.put(1, "宿舍单独居住");
        CONDITION_MAP.put(2, "宿舍集体居住");

        TRAFFIC_MAP.put(0, "步行/共享单车");
        TRAFFIC_MAP.put(1, "出租车/网约车");
        TRAFFIC_MAP.put(2, "自驾");
        TRAFFIC_MAP.put(3, "公司班车");
        TRAFFIC_MAP.put(4, "公共交通");
        TRAFFIC_MAP.put(5, "未出行");
    }
}
