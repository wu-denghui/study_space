package com.goodhealth.framework.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
/**
 * 执行定时任务的实体类
 */
public class TaskScheduleModel {
    /**
     * 计划执行开始时间
     */
    private Date scheduleStartTime;

    /**
     * 每个月于第几天
     */
    private Integer intervalDay;
    /**
     *  每天 '1'
     *
     */
    private Character everyWeekDay;

    /**
     * 按日 2
     * 按周 4
     * 按月 8
     * 间隔时间段 16
     * 特定时间 32
     */
    private Integer jobType;
    /**
     * 一周内的那几天{1,2,3,4,5,}
     */
    private Integer[] dayOfWeeks;
    /**
     * 每隔几周
     */
    private Integer intervalWeek;
    /**
     * 一个月中的某一天
     */
    private Integer whichDay;
    /**
     * 多个月份{1,3,5,12}
     */
    private Integer[] countOfMonths;
    /**
     * 当月的第几周
     */
    private Integer intervalDayOfWeek;
    /**
     * 当周的第几天
     */
    private Integer dayOfWeek;
    /**
     * 每隔几秒
     */
    private Integer intervalCountOfSecond;
    /**
     * 每隔几分钟
     */
    private Integer intervalCountOfMinute;
    /**
     *  当前小时的那几分钟
     */
    private Integer[] minituesOfHour;
    /**
     * 每隔几天
     */
    private Integer intervalCountOfDay;
    /**
     * 每隔几月
     */
    private Integer intervalCountOfMonth;
    /**
     * 当前天的那几个小时
     */
    private Integer[] hoursOfDay;
    /**
     * 每隔几小时
     */
    private Integer intervalCountOfHours;


}