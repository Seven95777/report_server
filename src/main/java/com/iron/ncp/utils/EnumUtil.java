package com.iron.ncp.utils;

/**
 * Description:通过msg获取枚举code
 * 使用：1、先让public enum BusinessCode implements CodeEnum接口；
 * 2、BusinessCode enumByCode = EnumUtil.getEnumByMsg(message, BusinessCode.class);
 *
 * Date: 2019/7/2
 */

/** 枚举工具类 */
public class EnumUtil {

    /**
     * 定义接口。用于反射范式编程
     */
    public interface CodeEnum {
        Integer getCode();

        String getMsg();
    }

    /** 通过msg获取枚举code*/
    public static <T extends CodeEnum> T getEnumByMsg(String msg, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (msg.equals(each.getMsg())) {
                return each;
            }
        }
        return null;
    }

    /** 通过msg获取枚举code*/
    public static <T extends CodeEnum> T getEnumByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
