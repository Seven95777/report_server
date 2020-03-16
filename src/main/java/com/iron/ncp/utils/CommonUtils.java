package com.iron.ncp.utils;

import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用工具类
 */
@Slf4j
public abstract class CommonUtils {

    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_MINUTE = "yyyy-MM-dd HH:mm";

    public static final String DATE = "yyyy-MM-dd";

    public static final String MONTH = "yyyy-MM";

    public static final DateTime DATE_TIME_MIN = new DateTime(1970, 1, 1, 0, 0, 0, 0);

    public static final DateTime DATE_TIME_MAX = new DateTime(2037, 12, 31, 23, 59, 59, 999);

    public static final Date DATE_MIN = DATE_TIME_MIN.toDate();

    public static final Date DATE_MAX = DATE_TIME_MAX.toDate();

    public static final Range<DateTime> DATE_TIME_RANGE = Range.closed(DATE_TIME_MIN, DATE_TIME_MAX);

    /**
     * URL正则表达式
     */
    public static final String URI = "[a-zA-z]+://[a-zA-Z0-9_.:/\\?%&=]{1,}";

    /**
     * DNS验证
     */
    public static final String DNS = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

    /**
     * 手机号码正则表达式
     */
    public static final String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    /**
     * 替换用ipv4正则表达式
     */
    public static final String IP_REGEX = "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

    public static final char[] NAME_CHARS = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static final char[] PASSWORD_CHARS = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=',
            '{', '}', '[', ']', '|', '\\',
            ':', '"', ';', '\'',
            '<', '>', ',', '.', '?', '/'
    };

    /**
     * 截取前置字符
     *
     * @param text  待处理字串
     * @param count 截取数目
     * @return 返回截取前置指定数目的字符串，字符串为空或者小于指定数目时返回原字符串
     */
    public static String first(String text, int count) {
        if (text == null || text.length() == 0 || count >= text.length()) {
            return text;
        }
        return text.substring(0, count);
    }


    /**
     * 截取前置的50个字符
     *
     * @param text 待处理字串
     * @return 返回截取前置50个字符的字符串，字符串为空或者小于50时返回原字符串
     */
    public static String first50(String text) {
        return first(text, 50);
    }

    /**
     * 安全的字符串转时间日期
     *
     * @param text    待处理字符串
     * @param pattern 模式
     * @return 空字符串或解析错误，亦或是模式不合法时返回null
     */
    public static Date parse(String text, String pattern) {
        if (text == null || text.length() == 0
                || pattern == null || pattern.length() == 0) {
            return null;
        }
        Date date = null;
        try {
            date = DateUtils.parseDate(text, pattern);
        } catch (Exception ignored) {
        }
        return date;
    }

    /**
     * 安全的字符串转joda time时间日期
     *
     * @param text    待处理字符串
     * @param pattern 模式
     * @return 空字符串或解析错误，亦或是模式不合法时返回null
     */
    public static DateTime parseJoda(String text, String pattern) {
        if (text == null || text.length() == 0
                || pattern == null || pattern.length() == 0) {
            return null;
        }
        DateTime date = null;
        try {
            date = DateTimeFormat.forPattern(pattern).parseDateTime(text);
        } catch (Exception ignored) {
        }
        return date;
    }

    /**
     * 安全的时间日期转字符串
     *
     * @param date    时间日期
     * @param pattern 模式
     * @return 空的数据日期或解析错误，亦或是模式不合法时返回null
     */
    public static String format(Date date, String pattern) {
        String s = "";
        if (date == null || pattern == null || pattern.length() == 0) {
            return s;
        }
        try {
            s = DateFormatUtils.format(date, pattern);
        } catch (Exception ignored) {
        }
        return s;
    }

    /**
     * 安全的计算时间差，分钟为单位
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return endTime - startTime的分钟数，空的参数会返回0
     */
    public static int getTimeDiff(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            return 0;
        }
        DateTime start = new DateTime(startTime);
        DateTime end = new DateTime(endTime);

        return Minutes.minutesBetween(start, end).getMinutes();
    }

    /**
     * 验证是否为合法数据区间
     *
     * @param mills 毫秒为单位的时间表示
     * @return 合法区间为[1970-01-01 00:00:00.000, 2037-12-31 23:59:59.999]
     */
    public static boolean isValidTimeRange(Long mills) {
        if (mills == null || mills < 0) {
            return false;
        }
        return DATE_TIME_RANGE.contains(new DateTime(mills));
    }

    /**
     * 验证日期的范围是否合法
     *
     * @param date 待验证日期
     * @return 合法, 返回构建的joda time对象；不合法，返回null
     */
    public static DateTime isValidTimeRange(Date date) {
        if (date == null) {
            return null;
        }
        DateTime dateTime = new DateTime(date);
        return DATE_TIME_RANGE.contains(dateTime) ? dateTime : null;
    }

    /**
     * 验证日期的范围是否合法，首先设置日期的时分秒毫秒为00:00:00.000
     *
     * @param date 待验证日期
     * @return 合法, 返回构建的joda time对象；不合法，返回null
     */
    public static DateTime isValidTimeRangeWith0(Date date) {
        if (date == null) {
            return null;
        }

        MutableDateTime mutableDateTime = new MutableDateTime(date);
        mutableDateTime.setHourOfDay(0);
        mutableDateTime.setMinuteOfHour(0);
        mutableDateTime.setSecondOfMinute(0);
        mutableDateTime.setMillisOfSecond(0);

        DateTime dateTime = mutableDateTime.toDateTime();
        return DATE_TIME_RANGE.contains(dateTime) ? dateTime : null;
    }


    /**
     * 校验url
     * @param url
     * @return
     */
    public static int urlCheck(String url) {
        Pattern p= Pattern.compile(URI);
        Matcher m=p.matcher(url);
        if(!m.matches()){
            return 1;
        }
        return 0;
    }


    public static double calSimilarity(Double[] a, Double[] b) {
        if (a == null || b == null || a.length == 0 || a.length != b.length) {
            return -1;
        }

        double ret = 0.0;
        for (int i = 0; i < a.length; i++) {
            ret += (a[i] * b[i]);
        }

        // 格式化三位小数
        DecimalFormat df = new DecimalFormat("######0.000");
        return Double.parseDouble(df.format(ret));
    }
}
