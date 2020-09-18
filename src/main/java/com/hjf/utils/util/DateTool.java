package com.hjf.utils.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateTool {

    /**
     * 命令：按照天增减
     */
    public static final int DAY = 1;
    /**
     * 命令：按照月增减
     */
    public static final int MONDTH = 2;

    /**
     *
     * @描述：得到当前系统的时间，例如:2008-08-08 08:08:08
     * @return currentTime 时间字符串  例如:2008-08-08 08:08:08
     */
    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime =format.format(new Date());
        return currentTime;
    }

    /**
     * @描述：把yyyy-MM-dd HH:mm:ss格式的字符串转换为日期格式
     * @param dateString 时间字符串，例如2008-08-08 08:08:08
     * @return date
     * @throws ParseException
     */
    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(dateString);
    }


    /**
     *
     * @描述：得到当前系统的时间，例如:2008-08-08
     * @return currentDay 日期字符串  例如:2008-08-08
     */
    public static String getCurrentDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    /**
     *
     * @描述：根据日期生产文件夹路径字符串，例如:2008/08/08
     * @return folderPath 文件夹字符串，例如2008/08/08
     */
    public static String createFolderByDateNow() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.format(new Date());
    }


    /**
     *
     * @描述：计算日期 根据某个日期 计算多少天以后的日期或者多少月以后的日期
     * @param time 要计算的日期原始数据 格式为：0000-00-00
     * @param type 只能是CalculationDate.DAY或者CalculationDate.MONDTH
     * @param count  要加或者减的具体数字
     * @return 经过计算,格式化后的日期 格式为：0000-00-00
     * @throws Exception type类型错误或者时间字符串转换错误
     */
    public static String calculationDate(String time, int type, int count) throws Exception  {

        String result = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (DAY == type) {
            calendar.add(Calendar.DATE, count);
            result = format.format(calendar.getTime());
        } else if (MONDTH == type) {
            calendar.add(Calendar.MONTH, count);
            result = format.format(calendar.getTime());
        } else {
            throw new Exception("操作类型出错，只能是月或者日增减");
        }
        return result;

    }

}
