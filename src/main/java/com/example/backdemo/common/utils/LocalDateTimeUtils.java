package com.example.backdemo.common.utils;

import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public final class LocalDateTimeUtils {

    /**
     * 日期格式yyyy-MM-dd
     */
    public static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     */
    public static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 构造函数
     */
    private LocalDateTimeUtils() {
        super();
    }

    /**
     * Date转LocalDateTime
     * 
     * @param date
     *            Date对象
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     * 
     * @param dateTime
     *            LocalDateTime对象
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     * 
     * @param dateTime
     *            LocalDateTime对象
     * @return
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDateTime(dateTime, DATE_TIME_PATTERN);
    }

    /**
     * 按pattern格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     * 
     * @param dateTime
     *            LocalDateTime对象
     * @param pattern
     *            要格式化的字符串
     * @return
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }
        if (pattern == null || pattern.isEmpty()) {
            pattern = DATE_TIME_PATTERN;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * 获取今天的00:00:00
     * 
     * @return
     */
    public static LocalDateTime getDayStart() {
        return getDayStart(LocalDateTime.now());
    }

    /**
     * 获取今天的23:59:59
     * 
     * @return
     */
    public static LocalDateTime getDayEnd() {
        return getDayEnd(LocalDateTime.now());
    }

    /**
     * 获取某天的00:00:00
     * 
     * @param dateTime
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime dateTime) {
        return dateTime.with(LocalTime.MIN);
    }

    /**
     * 获取某天的23:59:59
     * 
     * @param dateTime
     * @return
     */
    public static LocalDateTime getDayEnd(LocalDateTime dateTime) {
        return dateTime.with(LocalTime.MAX);
    }

    /**
     * 获取本月第一天的00:00:00
     * 
     * @return
     */
    public static LocalDateTime getFirstDayOfMonth() {
        return getFirstDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取本月最后一天的23:59:59
     * 
     * @return
     */
    public static LocalDateTime getLastDayOfMonth() {
        return getLastDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取某月第一天的00:00:00
     * 
     * @param dateTime
     *            LocalDateTime对象
     * @return
     */
    public static LocalDateTime getFirstDayOfMonth(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
    }

    /**
     * 获取某月最后一天的23:59:59
     * 
     * @param dateTime
     *            LocalDateTime对象
     * @return
     */
    public static LocalDateTime getLastDayOfMonth(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
    }


    /**
     * 获取当前时间一周的开始时间
     * @return
     */
    public static LocalDateTime getFirstDayofWeek() {
        DateTime dateTime = DateTime.now().withDayOfWeek(1).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0);
        return dateTime.toDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 获取当前时间一周的结束时间
     * @return
     */
    public static LocalDateTime getLastDayofWeek() {
        DateTime dateTime = DateTime.now().withDayOfWeek(7).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
        return dateTime.toDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    /**
     * 测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getDayStart());
        System.out.println(getDayEnd());
        System.out.println(getFirstDayOfMonth());
        System.out.println(getLastDayOfMonth());
        System.out.println(getFirstDayofWeek());
        System.out.println(getLastDayofWeek());
    }

}