package com.goodhealth.comm.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public interface GlobalEnum {

    enum StatusEnum {
        INVALID(0, "invalid", "无效"),
        EFFECTIVE(1, "effective", "有效"),
        OVER_TIME(2,"overtime","过期")
        ;

        private int code;

        private String name;

        private String desc;

        StatusEnum(int code, String name, String desc) {
            this.code = code;
            this.name = name;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }


    enum ValidTimeEnum {
        GENERAL(30*60*1000, "general", "普通token"),
        REFRESH(12*60*60*1000, "refresh", "重刷token"),
        ;
        private long code;

        private String name;

        private String desc;

        ValidTimeEnum(long code, String name, String desc) {
            this.code = code;
            this.name = name;
            this.desc = desc;
        }

        public long getCode() {
            return code;
        }

        public void setCode(long code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }


    enum WeekDayEnum {
        monday(1, "monday", "星期一"),
        tuesday(2, "tuesday", "星期二"),
        wednesday(3, "wednesday", "星期三"),
        thursday(4, "thursday", "星期四"),
        friday(5, "friday", "星期五"),
        saturday(6, "saturday", "星期六"),
        sunday(7, "sunday", "星期日"),
        ;

        private int code;

        private String name;

        private String desc;

        public static Map<Integer, String> getWeekMap() {
            Map<Integer, String> map = new HashMap<>();
            for (WeekDayEnum value : WeekDayEnum.values()) {
                map.put(value.code, value.desc);
            }
            return map;
        }

        public static Map<Integer, String> getWeekNameMap() {
            Map<Integer, String> map = new HashMap<>();
            for (WeekDayEnum value : WeekDayEnum.values()) {
                map.put(value.code, value.name);
            }
            return map;
        }

        WeekDayEnum(int code, String name, String desc) {
            this.code = code;
            this.name = name;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
