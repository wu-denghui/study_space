package com.goodhealth.design.advanced.BusinessAndScene.command;

/**
 * @ClassName MonitorCommand
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 19:20
 * @Version 1.0
 **/
public class MonitorCommand implements Command {

    @Override
    public void ation() {
        System.out.println("班长说上课认真听讲");
    }
}
