package com.goodhealth.comm.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    
    /**
     * 日期格式，月份，例如：09:00:00
     */
    public static final String HHMMSS = "HH:mm:ss";
    // ==格式到年==
    /**
     * 日期格式，年份，例如：2004，2008
     */
    public static final String YYYY = "yyyy";


    /**
     * 日期格式，月份，例如：01
     */
    public static final String MM = "MM";


    // ==格式到年月 ==
    /**
     * 日期格式，年份和月份，例如：200707，200808
     */
    public static final String YYYYMM = "yyyyMM";

    /**
     * 日期格式，年份和月份，例如：200707，2008-08
     */
    public static final String YYYY_MM = "yyyy-MM";


    // ==格式到年月日==
    /**
     * 日期格式，年月日，例如：050630，080808
     */
    public static final String YYMMDD = "yyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：06-12-25，08-08-08
     */
    public static final String YY_MM_DD = "yy-MM-dd";

    /**
     * 日期格式，年月日，例如：20050630，20080808
     */
    public static final String YYYYMMDD = "yyyyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式，年月日，例如：2016.10.05
     */
    public static final String POINTYYYYMMDD = "yyyy.MM.dd";

    /**
     * 日期格式，年月日，例如：2016年10月05日
     */
    public static final String CHINESE_YYYYMMDD = "yyyy年MM月dd日";

    /**
     * 日期格式，年月日，例如：2016年10月
     */
    public static final String CHINESE_YYYYMM = "yyyy年MM月";

    /**
     * 日期格式，年月日时分，例如：20001230 12:00，20080808 20:08
     */
    public static final String YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";

    /**
     * 日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
     */
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";

    /**
     * 日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
     */
    public static final String YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";


    // ==格式到年月日 时分秒==
    /**
     * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
     */
    public static final String YYYYMMDDHHMISS = "yyyyMMddHHmmss";

    /**
     * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
     * 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
     */
    public static final String YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";


    // ==格式到年月日 时分秒 毫秒==
    /**
     * 日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
     */
    public static final String YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";


    // ==特殊格式==
    /**
     * 日期格式，月日时分，例如：10-05 12:00
     */
    public static final String MMDDHHMI = "MM-dd HH:mm";

    /**
     * 获取 当前年、半年、季度、月、日、小时 开始结束时间
     */
    private static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_FORMAT = new SimpleDateFormat(YYYY_MM_DD);
    private static final SimpleDateFormat DATE_TIME_FORMAT_YYYY_MM_DD_HH_FORMAT = new SimpleDateFormat(YYYY_MM_DD_HH);
    private static final SimpleDateFormat DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT = new SimpleDateFormat(YYYY_MM_DD_HH_MI_SS);


    /**
     *  TODO 日期格式转成字符串格式
     * @param date
     * @param format
     * @return
     */
    public static String dateToStr(Date date, String format) {
        String str = "";
        try {
            DateFormat df = new SimpleDateFormat(format);
            str = df.format(date);
        } catch (Exception e) {
            LoggerUtil.error(e.getMessage());
        }
        return str;
    }

    /**
     *  时间戳转成指定格式日期字符串
     * @param obj
     * @param format
     * @return
     */
    public static String longToDateStr(Long obj, String format) {
        String str = "";
        try {
            if (obj == null && StringUtil.isBlank(format)) {
                return str;
            }
            DateFormat df = new SimpleDateFormat(format);
            str = df.format(obj);
        } catch (Exception e) {
            LoggerUtil.error(e.getMessage());
        }
        return str;
    }

    /**
     *  TODO 将日期格式字符串转成时间戳
     * @param s
     * @return
     */
    public static String dateToStamp(String s, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date = simpleDateFormat.parse(s);
            long ts = date.getTime();
            return String.valueOf(ts);
        } catch (Exception e) {
            LoggerUtil.error(e.getMessage());
        }
        return null;
    }
    public static String dateToStr(Date date) {
        return dateToStr(date, "yyyy-MM-dd HH:mm:ss");
    }
    /**
     * isWeekday
     * @param date
     * @return
     */
    public static boolean isWeekday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY
            || cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY);
    }

    /**
     * TODO 获得本周的第一天，周一
     *
     * @return
     */
    public static Date getCurrentWeekDayStartTime() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
            c.add(Calendar.DATE, -weekday);
            c.setTime(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()) + " 00:00:00"));
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return c.getTime();
    }

    /**
     * TODO 获得本周的最后一天，周日
     *
     * @return
     */
    public static Date getCurrentWeekDayEndTime() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DATE, 8 - weekday);
            c.setTime(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()) + " 23:59:59"));
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return c.getTime();
    }

    /**
     * TODO 获得本天的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentDayStartTime() {
        Date now = new Date();
        try {
            now = DATE_FORMAT_YYYY_MM_DD_FORMAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(now));
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     * TODO 获得本天的结束时间，即2012-01-01 23:59:59
     * @return
     */
    public static Date getCurrentDayEndTime() {
        Date now = new Date();
        try {
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(now) + " 23:59:59");
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     * TODO 获得本小时的开始时间，即2012-01-01 23:59:59
     *
     * @return
     */
    public static Date getCurrentHourStartTime() {
        Date now = new Date();
        try {
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_FORMAT.parse(DATE_TIME_FORMAT_YYYY_MM_DD_HH_FORMAT.format(now));
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     *  TODO 获得本小时的结束时间，即2012-01-01 23:59:59
     *
     * @return
     */
    public static Date getCurrentHourEndTime() {
        Date now = new Date();
        try {
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_TIME_FORMAT_YYYY_MM_DD_HH_FORMAT.format(now) + ":59:59");
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     *  TODO 获得本月的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            now = DATE_FORMAT_YYYY_MM_DD_FORMAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()));
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     *  TODO 当前月的结束时间，即2012-01-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentMonthEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     * TODO 当前年的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentYearStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = DATE_FORMAT_YYYY_MM_DD_FORMAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()));
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     * TODO 当前年的结束时间，即2012-12-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentYearEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    /**
     * TODO 当前季度的开始时间，即2012-01-1 00:00:00
     *
     * @return
     */
    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3){
                c.set(Calendar.MONTH, 0);
            }else if (currentMonth >= 4 && currentMonth <= 6){
                c.set(Calendar.MONTH, 3);
            }else if (currentMonth >= 7 && currentMonth <= 9){
                c.set(Calendar.MONTH, 4);
            }else if (currentMonth >= 10 && currentMonth <= 12){
                c.set(Calendar.MONTH, 9);
            }
            c.set(Calendar.DATE, 1);
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }

    
    /**
     * TODO 获取前/后半年的开始时间
     * @return
     */
    public static Date getHalfYearStartTime(){
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6){
                c.set(Calendar.MONTH, 0);
            }else if (currentMonth >= 7 && currentMonth <= 12){
                c.set(Calendar.MONTH, 6);
            }
            c.set(Calendar.DATE, 1);
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;

    }
    /**
     * TODO 获取前/后半年的结束时间
     * @return
     */
    public static Date getHalfYearEndTime(){
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6){
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            }else if (currentMonth >= 7 && currentMonth <= 12){
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_FORmAT.parse(DATE_FORMAT_YYYY_MM_DD_FORMAT.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            LoggerUtil.error("date util error:",e);
        }
        return now;
    }


    /**
     * @Title: compareDate
     * @Description: 比较时间大小（第一个时间在第二个时间之前返回-1；第一个时间在第二个时间之后返回1，相同返回0）
     * @param dt1
     * @param dt2
     * @return    参数说明
     * @return int    返回类型
     */
    public static int compareDate(Date dt1, Date dt2) {
        try {
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            LoggerUtil.error(e.getMessage(), e);
        }
        return 0;
    }

    public static Date UTCToDate(String UTCTime){
        Date resDate = null;
        if (StringUtil.isNotNullString(UTCTime)) {
            //转换日期格式(将2019-05-07T16:00:00.000Z 转换为一般Date)
            UTCTime = UTCTime.replace("Z", " UTC");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            try {
                resDate = sdf1.parse(UTCTime);
            } catch (ParseException e) {
                LoggerUtil.error(e.getMessage(), e);
            }
        }
        return resDate;
    }
    /**
     * @Title: getCurrentDate
     * @return getCurrentDate    返回类型
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * TODO 自定义格式化日期,
     * @param format
     * @param date
     * @return
     */
    public static String formatDateTime(Date date,String  format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.format(date.getTime());
        } catch (Exception e) {
            LoggerUtil.debug("DateUtils.getDateTime():" + e.getMessage());
            return "";
        }
    }


    /**
     * TODO 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }




    public static Date getDateFromHMS(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND,getSecond(time));

        calendar.set(Calendar.MINUTE,getMinute(time));

        calendar.set(Calendar.HOUR_OF_DAY,getHourOfDay(time));
        return calendar.getTime();
    }


    public static int getSecond(Date startTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        return calendar.get(Calendar.SECOND);
    }

    public static int getMinute(Date startTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getHourOfDay(Date startTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getDayOfMonth(Date startTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date startTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        return calendar.get(Calendar.MONTH);
    }

    public static int getYear(Date startTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * TODO 根据日期获取星期
     * @param date
     * @param firstDayIsMonday 星期的第一天是否是周一
     * @return
     */
    public static int getWeek(Date date, Boolean firstDayIsMonday) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (firstDayIsMonday) {
            int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            return week == 0 ? 7 : week;
        }
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int getMaxDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year - 1);
        calendar.set(Calendar.MONTH, month);
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * TODO 时间date1和date2的时间差-单位秒
     *
     * @param date1
     * @param date2
     * @return 秒
     */
    public static long subtract(Date date1, Date date2) {
        long cha = (date2.getTime() - date1.getTime()) / 1000;
        return cha;
    }

    /**
     * TODO 时间date1和date2的时间差-单位分钟
     *
     * @param date1
     * @param date2
     * @return 分钟
     */
    public static int subtractMinute(Date date1, Date date2) {
        long cha = date2.getTime() - date1.getTime();
        return (int) cha / (1000 * 60);
    }

    /**
     * TODO 时间date1和date2的时间差-单位小时
     *
     * @param date1
     * @param date2
     * @return 小时
     */
    public static int subtractHour(Date date1, Date date2) {
        long cha = (date2.getTime() - date1.getTime()) / 1000;
        return (int) cha / (60 * 60);
    }

    /**
     * TODO 时间date1和date2的时间差-单位天
     *
     * @param date1
     * @param date2
     * @return 小时
     */
    public static int subtractDay(Date date1, Date date2) {
        long cha = (date2.getTime() - date1.getTime()) / 1000;
        return (int) cha / (60 * 60 * 24);
    }


    /**
     *
     * @Description: TODO 获取两个日期之间日期的
     * @param @param startDate 开始日期 date类型
     * @param @param endDate  结束日期 date类型
     * @param @return
     * @return List<Date>  datelist
     * @throws
     */
    public static List<String> get2DateListWithDate(Date startDate, Date endDate, String format) {
        List<String> list = new ArrayList<>();
        if(startDate.getTime() >endDate.getTime()){
            return list;
        }

        String startDateStr = DateUtils.formatDateTime(startDate, format);
        String endDateStr = DateUtils.formatDateTime(endDate, format);
        if (isSameDay(startDate,endDate)) {
            list.add(startDateStr);
            return list;
        }
        Date nextDate = DateUtils.getDayAfter(startDate);
        String nextDateStr = DateUtils.formatDateTime(nextDate, format);
        //String endDateStr = DateUtils.date2String(endDate, format);
//        list.add(startDate);
        list.add(nextDateStr);
        while (!isSameDay(nextDate,endDate)) {
            Date nextnextDate = DateUtils.getDayAfter(nextDate);
            String nextnextDateStr = DateUtils.formatDateTime(nextDate, format);

            list.add(nextnextDateStr);
            nextDate = nextnextDate;
        }
        return list;
    }


    /**
     * TODO 获得指定日期的后num天
     *
     * @param
     * @return
     */
    public static Date getDayAfter(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + num);
        Date dayAfter = c.getTime();
        return dayAfter;
    }
    /**
     * TODO 获得指定日期的明天
     * @param
     * @return
     */
    public static Date getDayAfter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day);
        Date dayAfter = c.getTime();
        return dayAfter;
    }


}

