package org.gdz.mycloud.common.base.util;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * DateUtil
 * 日期转换工具类
 *
 * @author guduzhou
 * @date 2019年5月20日 下午3:48:39
 */
@Slf4j
public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_FORMAT = "yyyy-MM-dd";


    /**
     * 获取系统当前日期
     *
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }
    /**
     * 获取当前年月日
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }


    /**
     * 根据时间格式返回对应的String类型的时间
     *
     * @param format
     * @return
     */
    public static String getCurDateTime(String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        String dateTime = now.format(dateTimeFormatter);
        return dateTime;
    }
    /**
     * 根据时间格式返回对应的String类型的时间
     *
     * @param format
     * @return
     */
    public static String getCurDate(String format) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        String date = now.format(dateTimeFormatter);
        return date;
    }

    /**
     * 根据时间格式返回对应的String类型的时间
     *
     * @return
     */
    public static String getDateTimeStr(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String dateTime = localDateTime.format(dateTimeFormatter);
        return dateTime;
    }

    /**
     * 根据时间格式返回对应的String类型的时间
     *
     * @param format
     * @return
     */
    public static String getDateTimeStr(LocalDateTime localDateTime ,String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        String dateTime = localDateTime.format(dateTimeFormatter);
        return dateTime;
    }


    /**
     * 得到当前日期
     *
     * @return String 当前日期 yyyy-MM-dd HH:mm:ss格式
     * @author kevin
     */
    public static String getDefaultCurDateTime() {
        return getCurDateTime(DATE_FORMAT);
    }


    /**
     * string 转 LocalDateTime
     *
     * @param dateStr 例："2017-08-11 01:00:00"
     * @param format  例："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static LocalDateTime stringToLocalDateTime(String dateStr, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDateTime.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Date转换为LocalDateTime
     *
     * @param date
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }
}
