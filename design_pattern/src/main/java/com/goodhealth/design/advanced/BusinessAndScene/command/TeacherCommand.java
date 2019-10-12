package com.goodhealth.design.advanced.BusinessAndScene.command;

/**
 * @ClassName TeacherCommand
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 19:28
 * @Version 1.0
 **/
public class TeacherCommand implements Command {

    @Override
    public void ation() {
        System.out.println("老师说中午留下了打扫卫生");
    }
}
