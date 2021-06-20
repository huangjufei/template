package com.hjf.utils.util;

import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {
    private DateTimeUtils() {
    }

    public final static String YYYYMMDD = "yyyy-MM-dd";
    public final static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYYMMDDHMS = "yyyy-MM-ddHHmmss";
    private final static DateTimeFormatter COMMON_FORMATTER = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS);

    private final static ZoneOffset DEFAULT_ZONE_OFFSET = ZoneOffset.of("+8");

    public static String dateToString(LocalDateTime dateTime) {
        assert dateTime != null;
        return COMMON_FORMATTER.format(dateTime);
    }

    public static LocalDateTime stringToDate(String dateStr) {
        assert dateStr != null;
        return LocalDateTime.parse(dateStr, COMMON_FORMATTER);
    }


    public static String dateToString(LocalDateTime dateTime, DateTimeFormatter formatter) {
        assert dateTime != null;
        return formatter.format(dateTime);
    }

    public static LocalDateTime stringToDate(String dateStr, DateTimeFormatter formatter) {
        assert dateStr != null;
        return LocalDateTime.parse(dateStr, formatter);
    }

    public static long dateToTimeMillis(LocalDateTime dateTime) {
        assert dateTime != null;
        return dateTime.toInstant(DEFAULT_ZONE_OFFSET).toEpochMilli();
    }

    public static LocalDateTime timeMillisToDate(long timeMillis) {
        Instant instant = Instant.ofEpochMilli(timeMillis);
        return LocalDateTime.ofInstant(instant, DEFAULT_ZONE_OFFSET);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return  LocalDateTime.ofInstant(date.toInstant(), DEFAULT_ZONE_OFFSET);
    }

    public static String dateToString(Date date,String format) {
        if(StringUtils.isEmpty(format)){
            format = YYYYMMDDHHMMSS;
        }
        return DateTimeFormatter.ofPattern(format).format(dateToLocalDateTime(date));
    }




    public static void main(String[] args) {
        String s = dateToString(LocalDateTime.now());
        System.out.println(s);
        System.out.println();
        String dateStr = "2019-01-01 12:12:12";
        LocalDateTime localDateTime = stringToDate(dateStr);
        System.out.println(localDateTime);
        System.out.println();
        System.out.println(dateToTimeMillis(localDateTime));
        System.out.println();
        System.out.println(timeMillisToDate(System.currentTimeMillis()));



    }
}
