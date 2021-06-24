package com.hjf.utils.date;

import com.hjf.utils.pingan.utils.EmptyChecker;
import com.hjf.utils.pingan.utils.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_SOLIDUS = "yyyy/MM/dd";
    public static final String DATE_FORMAT_COMPACT = "yyyyMMdd";
    public static final String DATE_FORMAT_UTC_DEFAULT = "MM-dd-yyyy";
    public static final String DATE_FORMAT_UTC_SOLIDUS = "MM/dd/yyyy";

    public static final String DATE_FORMAT_CHINESE = "yyyy年MM月dd日";
    public static final String DATE_TIME_FORMAT_COMPACT = "yyyyMMdd HHmmss";
    public static final String DATE_TIME_FORMAT_CHINESE = "yyyy年MM月dd日 HH时mm分ss秒";

    public static final String DATE_TIME_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_SOLIDUS = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_UTC_DEFAULT = "MM-dd-yyyy HH:mm:ss";
    public static final String DATE_TIME_FORMAT_UTC_SOLIDUS = "MM/dd/yyyy HH:mm:ss";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String CMS_DRAW_SEQUENCE_FORMAT = "yyyyMMddhhmmss";
    public static final String MATCH_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_TIME_STRING_FORMAT = "yyyyMMdd HH:mm:ss";
    public static final String DATE_STRING_FORMAT = "yyyyMMdd";
    public static final String SCH_REPORT_DATE_FORMAT = "yyyyMMddHHmmss";

    public static final int ONE_DAY_SECONDS = 86400;
    public static final int ONE_HOUR_SECONDS = 3600;

    private static Map<String, String> dateFormatRegisterMap = new HashMap<>();

    static {
        dateFormatRegisterMap.put(DATE_FORMAT_COMPACT, "^\\d{8}$");
        dateFormatRegisterMap.put(DATE_FORMAT_DEFAULT, "^\\d{4}-\\d{1,2}-\\d{1,2}$");
        dateFormatRegisterMap.put(DATE_FORMAT_SOLIDUS, "^\\d{4}/\\d{1,2}/\\d{1,2}$");
        dateFormatRegisterMap.put(DATE_FORMAT_UTC_DEFAULT, "^\\d{1,2}-\\d{1,2}-\\d{4}$");
        dateFormatRegisterMap.put(DATE_FORMAT_UTC_SOLIDUS, "^\\d{1,2}/\\d{1,2}/\\d{4}$");
        dateFormatRegisterMap.put(DATE_TIME_FORMAT_DEFAULT, "^\\d{4}-\\d{1,2}-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        dateFormatRegisterMap.put(DATE_TIME_FORMAT_SOLIDUS, "^\\d{4}/\\d{1,2}/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        dateFormatRegisterMap.put(DATE_TIME_FORMAT_UTC_DEFAULT,
                "^\\d{1,2}-\\d{1,2}-\\d{4}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        dateFormatRegisterMap.put(DATE_TIME_FORMAT_UTC_SOLIDUS,
                "^\\d{1,2}/\\d{1,2}/\\d{4}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");
    }

    private static final String FORMAT_TYPE = "unsupported date type:%s";

    private DateUtils() {
    }

    public static String format(String formatString, Date date) {
        return new SimpleDateFormat(formatString).format(date);
    }

    public static Date parseDate(String src) {
        if (EmptyChecker.isEmpty(src)) {
            return null;
        }
        return parseDate(src, DATE_FORMAT_DEFAULT);
    }

    public static Date parseDate(String src, String dateTemplate) {
        if (EmptyChecker.isEmpty(src)) {
            return null;
        }
        try {
            return new SimpleDateFormat(dateTemplate).parse(src);
        } catch (ParseException e) {
            throw new RuntimeException(String.format("unsupported date template:%s", src), e);
        }
    }

    public static <T> T parseDate(String src, Class<T> dateClazz) {

        if (EmptyChecker.isEmpty(src)) {
            return null;
        }

        return convertDate(parseDate(src), dateClazz);
    }

    public static <T> T parseDate(String src, String dateTemplate, Class<T> dateClazz) {

        if (EmptyChecker.isEmpty(src)) {
            return null;
        }

        return convertDate(parseDate(src, dateTemplate), dateClazz);
    }


    public static String formatDate(Date date) {

        if (EmptyChecker.isEmpty(date)) {
            return null;
        }

        return formatDate(date, DATE_FORMAT_DEFAULT);
    }

    public static String formatDate(Date date, String dateTemplate) {
        if (EmptyChecker.isEmpty(date) || EmptyChecker.isEmpty(dateTemplate)) {
            return null;
        }

        return new SimpleDateFormat(dateTemplate).format(date);
    }

    public static <T> T convertDate(Date src, Class<T> dateClazz) {

        if (EmptyChecker.isEmpty(src)) {
            return null;
        }

        try {

            return dateClazz.getConstructor(long.class).newInstance(src.getTime());
        } catch (Exception e) {
            Logger.error(DateUtils.class, String.format(FORMAT_TYPE, dateClazz.getName()), e);
            throw new RuntimeException(String.format(FORMAT_TYPE, dateClazz.getName()), e);
        }
    }


    private static long render(long i, int j, int k) {
        return (i + (i > 0 ? j : -j)) / k;
    }

    /**
     * 时间相差的秒数
     *
     * @param start 被减的时间
     * @param end   减的时间
     * @return 相差的秒数
     */
    public static long diffSecond(Date start, Date end) {
        return render(end.getTime() - start.getTime(), 999, 1000);
    }

    public static long diffMinute(Date end) {
        return diffMinute(new Date(System.currentTimeMillis()), end);
    }

    public static long diffMinute(Date start, Date end) {
        return render(diffSecond(start, end), 59, 60);
    }

    public static long diffHour(Date start, Date end) {
        return render(diffMinute(start, end), 59, 60);
    }

    public static long diffDay(Date start, Date end) {
        return offset(start, end, Calendar.DAY_OF_YEAR);
    }

    public static long diffMonth(Date start, Date end) {
        return offset(start, end, Calendar.MONTH) + diffYear(start, end);
    }

    public static long diffYear(Date start, Date end) {
        Calendar s = Calendar.getInstance();
        Calendar e = Calendar.getInstance();
        s.setTime(start);
        e.setTime(end);
        return Math.subtractExact(e.get(Calendar.YEAR), s.get(Calendar.YEAR));
    }

    private static long offset(Date start, Date end, int offsetCalendarField) {

        boolean bool = start.before(end);
        long rtn = 0;
        Calendar s = Calendar.getInstance();
        Calendar e = Calendar.getInstance();

        s.setTime(bool ? start : end);
        e.setTime(bool ? end : start);

        rtn -= s.get(offsetCalendarField);
        rtn += e.get(offsetCalendarField);

        while (s.get(Calendar.YEAR) < e.get(Calendar.YEAR)) {
            rtn += s.getActualMaximum(offsetCalendarField);
            s.add(Calendar.YEAR, 1);
        }

        return bool ? rtn : -rtn;
    }

    public static Date add(Date date, int n, int calendarField) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, n);

        return c.getTime();
    }

    public static String formatDateAsCmsDrawSequence(Date date) {
        return formatDate(date, CMS_DRAW_SEQUENCE_FORMAT);
    }

    public static String formatDateSchReport(Date date) {
        return formatDate(date, SCH_REPORT_DATE_FORMAT);
    }


    public static String formatDateTime(Date date) {
        return (date == null) ? null : formatDate(date, DATE_TIME_FORMAT);
    }

    public static Date parseDateTime(String date) {
        return parseDate(date, DATE_TIME_FORMAT);
    }

    public static String formatDateAsMatchTime(Date date) {
        return formatDate(date, MATCH_TIME_FORMAT);
    }

    public static String formatDateAsString(Date date) {
        return formatDate(date, DATE_STRING_FORMAT);
    }

    public static boolean compareTillSecond(Date oneDate, Date anotherDate) {
        if (oneDate == null || anotherDate == null) {
            return false;
        }
        return format(DATE_TIME_FORMAT_DEFAULT, oneDate).equals(format(DATE_TIME_FORMAT_DEFAULT, anotherDate));
    }

    public static boolean compareWithInterval(Date oneDate, Date anotherDate, int interval) {
        if (oneDate == null || anotherDate == null) {
            return false;
        }
        long oneTime = oneDate.getTime();
        long anotherTime = anotherDate.getTime();
        return Math.abs(oneTime - anotherTime) / 1000 <= interval;
    }

    public static String getDateSeq() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date currentDate = new Date();
        Random random = new Random();
        Integer ran = random.nextInt(900) + 100;
        return sb.append(format.format(currentDate)).append(ran.toString()).toString();
    }
}
