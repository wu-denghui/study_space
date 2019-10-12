package com.goodhealth.framework.util;



import com.goodhealth.comm.util.DateUtils;
import com.goodhealth.framework.entity.TaskScheduleModel;

import java.util.Date;

/**
 * @Auther: WDH
 * @Date: 2019/3/12 23:56
 * @Description:
 */

public class CronUtils {

//

    /**
     *
     *方法摘要：构建Cron表达式
     *@param  taskScheduleModel
     *@return String
     */
    public static String createCronExpression(TaskScheduleModel taskScheduleModel){
        StringBuffer cronExp = new StringBuffer("");

        //计划执行开始时间
        Date startTime = taskScheduleModel.getScheduleStartTime();

        if(null != startTime){
            //秒
            cronExp.append(DateUtils.getSecond(startTime)).append(" ");
            //分
            cronExp.append(DateUtils.getMinute(startTime)).append(" ");
            //小时
            cronExp.append(DateUtils.getHourOfDay(startTime)).append(" ");

            //按每天
            if(taskScheduleModel.getJobType().intValue() == 2){
                //每工作日
                if(taskScheduleModel.getEveryWeekDay().charValue() == '1'){
                    //一个月中第几天
                    cronExp.append("? ");
                    //月份
                    cronExp.append("* ");
                    //星期[星期一到星期五]
                    cronExp.append("2-6");
                } else{
                    //一个月中第几天
                    cronExp.append("*/").append(taskScheduleModel.getIntervalDay()).append(" ");
                    //月份
                    cronExp.append("* ");
                    //星期
                    cronExp.append("?");
                }
            }

            //按每周
            else if(taskScheduleModel.getJobType().intValue() == 4){
                //一个月中第几天
                cronExp.append("? ");
                //月份
                cronExp.append("* ");
                //周
                Integer[] weeks = taskScheduleModel.getDayOfWeeks();
                for(int i = 0; i < weeks.length; i++){
                    if(i == 0){
                        cronExp.append(weeks[i]);
                    } else{
                        cronExp.append(",").append(weeks[i]);
                    }
                }

                //每隔?周
                if(taskScheduleModel.getIntervalWeek().intValue() > 0){
                    cronExp.append("/").append(taskScheduleModel.getIntervalWeek());
                }
            }

            //按每月
            else if(taskScheduleModel.getJobType().intValue() == 8){
                //当前年份
                int currentYear = DateUtils.getYear(startTime);
                //当前月份
                int currentMonth = DateUtils.getMonth(startTime);
                //当前月份的最大天数
                int maxDayOfMonth = DateUtils.getMaxDayOfMonth(currentYear, currentMonth);

                //月份中具体某一天
                if (null != taskScheduleModel.getWhichDay())
                {
                    //如果所选日期数大于当月最大天数，则默认表示当月最后一天
                    if(taskScheduleModel.getWhichDay() > maxDayOfMonth){
                        cronExp.append("L ");
                    }
                    else{
                        cronExp.append(taskScheduleModel.getWhichDay()).append(" ");
                    }
                } else{
                    cronExp.append("? ");
                }

                //指定多个月份
                if(null != taskScheduleModel.getCountOfMonths()){
                    for(int i = 0; i < taskScheduleModel.getCountOfMonths().length; i++){
                        if(i == taskScheduleModel.getCountOfMonths().length - 1){
                            cronExp.append(taskScheduleModel.getCountOfMonths()[i]);
                        } else{
                            cronExp.append(taskScheduleModel.getCountOfMonths()[i]).append(",");
                        }
                    }
                    cronExp.append(" ");
                } else{
                    cronExp.append("? ");
                }

                //当月第几周的周几
                if(null == taskScheduleModel.getIntervalDayOfWeek() || taskScheduleModel.getIntervalDayOfWeek() == 0){
                    cronExp.append("? ");
                } else if(taskScheduleModel.getIntervalDayOfWeek() > 4){
                    cronExp.append("L "); //超过4，表示当月最后一周
                } else{
                    if(null == taskScheduleModel.getDayOfWeek()){
                        cronExp.append("*#").append(taskScheduleModel.getIntervalDayOfWeek());
                    } else{
                        cronExp.append(taskScheduleModel.getDayOfWeek()).append("#").append(taskScheduleModel.getIntervalDayOfWeek());
                    }
                }
            }

            //按间隔时间段
            else if(taskScheduleModel.getJobType().intValue() == 16){
                cronExp = new StringBuffer("");
                //秒
                if(null == taskScheduleModel.getIntervalCountOfSecond() || taskScheduleModel.getIntervalCountOfSecond().intValue() == 0){
                    cronExp.append(DateUtils.getSecond(startTime)).append(" ");
                } else{
                    cronExp.append(DateUtils.getSecond(startTime)).append("/");
                    cronExp.append(taskScheduleModel.getIntervalCountOfSecond()).append(" ");
                }
                //分
                if(null == taskScheduleModel.getIntervalCountOfMinute() || taskScheduleModel.getIntervalCountOfMinute().intValue() == 0){
                    cronExp.append(DateUtils.getMinute(startTime)).append(" ");
                } else{
                    cronExp.append(DateUtils.getMinute(startTime)).append("/");
                    cronExp.append(taskScheduleModel.getIntervalCountOfMinute()).append(" ");
                }

                //小时
                if(null == taskScheduleModel.getIntervalCountOfHours() || taskScheduleModel.getIntervalCountOfHours().intValue() == 0){
                    cronExp.append(DateUtils.getHourOfDay(startTime)).append(" ");
                } else{
                    cronExp.append(DateUtils.getHourOfDay(startTime)).append("/");
                    cronExp.append(taskScheduleModel.getIntervalCountOfHours()).append(" ");
                }

                //日期
                if(null == taskScheduleModel.getIntervalCountOfDay() || taskScheduleModel.getIntervalCountOfDay().intValue() == 0){
                    cronExp.append(DateUtils.getDayOfMonth(startTime)).append(" ");
                } else{
                    cronExp.append(DateUtils.getDayOfMonth(startTime)).append("/");
                    cronExp.append(taskScheduleModel.getIntervalCountOfDay()).append(" ");
                }

                //月
                if(null == taskScheduleModel.getIntervalCountOfMonth()){
                    cronExp.append(DateUtils.getMonth(startTime)).append(" ");
                } else if (taskScheduleModel.getIntervalCountOfMonth().intValue() == 0) {
                    cronExp.append("* ");
                } else{
                    cronExp.append(DateUtils.getMonth(startTime)).append("/");
                    cronExp.append(taskScheduleModel.getIntervalCountOfMonth());
                }

                //周 因为cron表达式无法同时支持 星期和天数间隔
                cronExp.append(" ?");

            }

            // 按特定时间点
            else if(taskScheduleModel.getJobType().intValue() == 32){
                cronExp = new StringBuffer("* ");
                if(taskScheduleModel.getMinituesOfHour() != null && taskScheduleModel.getMinituesOfHour().length > 0) {
                    int index = 0;
                    for(int minitue : taskScheduleModel.getMinituesOfHour()) {
                        if(index == taskScheduleModel.getMinituesOfHour().length - 1) {
                            cronExp.append(minitue);
                        } else {
                            cronExp.append(minitue).append(",");
                        }
                        index++;
                    }
                }
                if(taskScheduleModel.getHoursOfDay() != null && taskScheduleModel.getHoursOfDay().length > 0) {
                    if(taskScheduleModel.getMinituesOfHour() != null && taskScheduleModel.getMinituesOfHour().length > 0) {
                        cronExp.append(" ");
                    }
                    int index = 0;
                    for(int hour : taskScheduleModel.getHoursOfDay()) {
                        if(index == taskScheduleModel.getHoursOfDay().length - 1) {
                            cronExp.append(hour);
                        } else {
                            cronExp.append(hour).append(",");
                        }
                        index++;
                    }
                }
                cronExp.append(" * * *");
            }
        }
        return cronExp.toString();
    }


    public static void main(String[] args) {
        TaskScheduleModel taskScheduleModel = new TaskScheduleModel();
        taskScheduleModel.setScheduleStartTime(new Date());
        taskScheduleModel.setJobType(16);
        Integer[] weekdays = {2,3,4,5,6};
        taskScheduleModel.setIntervalCountOfDay(3);
        taskScheduleModel.setDayOfWeeks(weekdays);
        System.out.println(CronUtils.createCronExpression(taskScheduleModel));
    }
}
//    /**
//     *
//     *方法摘要：生成计划的详细描述
//     *@param  taskScheduleModel
//     *@return String
//     */
//    public static String createDescription(TaskScheduleModel taskScheduleModel){
//        StringBuffer description = new StringBuffer("");
//        //简单任务
//        if(taskScheduleModel.getJobType().intValue() == 1){
//            description.append("简单任务，延迟(ms):");
//            description.append(taskScheduleModel.getScheduleInterval());
//            if(taskScheduleModel.getScheduleRepeatCount() <= 0) {
//                description.append(",执行次数:无限制，永远循环执行下去。");
//            } else {
//                description.append(",重复执行次数:");
//                description.append(taskScheduleModel.getScheduleRepeatCount());
//            }
//        }
//        //系统启动时
//        else if(taskScheduleModel.getJobType().intValue() == 64){
//            description.append("系统启动时执行");
//        }
//        else{
//            //计划执行开始时间
//            Date startTime = taskScheduleModel.getScheduleStartTime();
//
//            if(null != startTime){
//                //按每天
//                if(taskScheduleModel.getJobType().intValue() == 2){
//                    //每工作日
//                    if(taskScheduleModel.getEveryWeekDay().charValue() == '1'){
//                        description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                        description.append("起，于每个工作日").append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                        description.append("执行");
//                    } else{
//                        //每天
//                        if(taskScheduleModel.getIntervalDay().intValue() == 0){
//                            description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                            description.append("起，于每天").append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                            description.append("执行");
//                        }
//                        //每间隔?天
//                        else{
//                            description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                            description.append("起，每隔").append(taskScheduleModel.getIntervalDay()).append("天，于");
//                            description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                            description.append("执行");
//                        }
//                    }
//                }
//
//                //按每周
//                else if(taskScheduleModel.getJobType().intValue() == 4){
//                    if(startTime != null) {
//                        description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                        description.append("起");
//                    }
//                    //每隔?周
//                    if(taskScheduleModel.getIntervalWeek().intValue() > 0){
//                        description.append("，每隔").append(taskScheduleModel.getIntervalWeek()).append("周");
//                    }
//                    if(taskScheduleModel.getDayOfWeeks() != null && taskScheduleModel.getDayOfWeeks().length > 0) {
//                        description.append("，于每周的").append(DateUtils.getWeekString(taskScheduleModel.getDayOfWeeks())).append(" ");
//                    }
//                    if(startTime != null) {
//                        description.append(" ,").append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                    }
//                    description.append("执行");
//                }
//
//                //按每月
//                else if(taskScheduleModel.getJobType().intValue() == 8){
//                    description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//
//                    //选择月份
//                    if(null != taskScheduleModel.getCountOfMonths() && taskScheduleModel.getCountOfMonths().length != 0){
//                        description.append("起，于");
//                        description.append(DateUtils.getMonthString(taskScheduleModel.getCountOfMonths()));
//                    } else{
//                        description.append("起，于每月的");
//                        if(null != taskScheduleModel.getWhichDay() && taskScheduleModel.getWhichDay().intValue() != 0){
//                            //当前年份
//                            int currentYear = DateUtils.getYear(startTime);
//                            //当前月份
//                            int currentMonth = DateUtils.getMonth(startTime);
//                            //当前月份的最大天数
//                            int maxDayOfMonth = DateUtils.getMaxDayOfMonth(currentYear, currentMonth);
//                            if(taskScheduleModel.getWhichDay() > maxDayOfMonth){
//                                description.append("最后一天");
//                            } else{
//                                description.append(taskScheduleModel.getWhichDay()).append("号");
//                            }
//                        }
//                    }
//
//                    //第几个星期
//                    if(null != taskScheduleModel.getIntervalDayOfWeek() && taskScheduleModel.getIntervalDayOfWeek().intValue() != 0){
//                        if(taskScheduleModel.getIntervalDayOfWeek() > 4){
//                            description.append("最后一个星期");
//                        } else{
//                            description.append("第").append(taskScheduleModel.getIntervalDayOfWeek());
//                            description.append("个星期");
//                        }
//                    }
//
//                    //星期几
//                    if(null != taskScheduleModel.getDayOfWeek() && taskScheduleModel.getDayOfWeek().intValue() != 0){
//                        description.append("的").append(DateUtils.getWeekString(taskScheduleModel.getDayOfWeek()));
//                    } else{
//                        description.append("的每天");
//                    }
//                    description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                    description.append("执行");
//                }
//
//                //按每间隔时间段
//                else if(taskScheduleModel.getJobType().intValue() == 16){
//                    //没填写间隔信息
//                    if((null == taskScheduleModel.getIntervalCountOfSecond() || taskScheduleModel.getIntervalCountOfSecond().intValue() == 0) &&
//                            (null == taskScheduleModel.getIntervalCountOfMinute() || taskScheduleModel.getIntervalCountOfMinute().intValue() == 0) &&
//                            (null == taskScheduleModel.getIntervalCountOfHours() || taskScheduleModel.getIntervalCountOfHours().intValue() == 0) &&
//                            (null == taskScheduleModel.getIntervalCountOfDay() || taskScheduleModel.getIntervalCountOfDay().intValue() == 0) &&
//                            (null == taskScheduleModel.getIntervalCountOfMonth() || taskScheduleModel.getIntervalCountOfMonth().intValue() == 0)
//                    ){
//                        description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                        description.append("起，于");
//                        description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                        description.append("执行一次");
//                    } else{
//                        //秒
//                        if(null != taskScheduleModel.getIntervalCountOfSecond() && taskScheduleModel.getIntervalCountOfSecond().intValue() != 0){
//                            description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                            description.append("起，每隔");
//                            description.append(taskScheduleModel.getIntervalCountOfSecond()).append("秒，于");
//                            description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                            description.append("执行");
//                        }
//                        //分
//                        if(null != taskScheduleModel.getIntervalCountOfMinute() && taskScheduleModel.getIntervalCountOfMinute().intValue() != 0){
//                            description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                            description.append("起，每隔");
//                            description.append(taskScheduleModel.getIntervalCountOfMinute()).append("分钟，于");
//                            description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                            description.append("执行");
//                        }
//                        //小时
//                        if(null != taskScheduleModel.getIntervalCountOfHours() && taskScheduleModel.getIntervalCountOfHours().intValue() != 0){
//                            description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                            description.append("起，每隔");
//                            description.append(taskScheduleModel.getIntervalCountOfHours()).append("小时，于");
//                            description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                            description.append("执行");
//                        }
//                        //日
//                        if(null != taskScheduleModel.getIntervalCountOfDay() && taskScheduleModel.getIntervalCountOfDay().intValue() != 0){
//                            description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                            description.append("起，每隔");
//                            description.append(taskScheduleModel.getIntervalCountOfDay()).append("天，于");
//                            description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                            description.append("执行");
//                        }
//                        //月
//                        if(null != taskScheduleModel.getIntervalCountOfMonth() && taskScheduleModel.getIntervalCountOfMonth().intValue() != 0){
//                            description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd"));
//                            description.append("起，每隔");
//                            description.append(taskScheduleModel.getIntervalCountOfMonth()).append("个月，于");
//                            description.append(DateUtils.parseDate(startTime, "HH:mm:ss"));
//                            description.append("执行");
//                        }
//                    }
//                }
//
//                //按特定时间点
//                else if(taskScheduleModel.getJobType().intValue() == 32){
//                    if(startTime != null) {
//                        description.append("从").append(DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm:ss"));
//                        description.append("起开始执行");
//                    }
//                    if(taskScheduleModel.getHoursOfDay() != null && taskScheduleModel.getHoursOfDay().length > 0) {
//                        int index = 0;
//                        description.append("，此后于每天的");
//                        for(int hour : taskScheduleModel.getHoursOfDay()) {
//                            if(index == taskScheduleModel.getHoursOfDay().length - 1) {
//                                description.append(hour + 1).append("点");
//                            } else {
//                                description.append(hour + 1).append("点,");
//                            }
//                            index++;
//                        }
//                    }
//                    if(taskScheduleModel.getMinituesOfHour() != null && taskScheduleModel.getMinituesOfHour().length > 0) {
//                        int index = 0;
//                        description.append(",");
//                        for(int minitue : taskScheduleModel.getMinituesOfHour()) {
//                            if(index == taskScheduleModel.getMinituesOfHour().length - 1) {
//                                description.append(minitue + 1).append("分");
//                            } else {
//                                description.append(minitue + 1).append("分,");
//                            }
//                            index++;
//                        }
//                    }
//                    description.append("定时执行");
//                }
//            }
//        }
//        return description.toString();
//    }
