package com.goodhealth.design.advanced.BusinessAndScene.command;

/**
 * @ClassName MotherCommand
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 19:23
 * @Version 1.0
 **/
public class MotherCommand implements Command {

    @Override
    public void ation() {
        System.out.println("妈妈说早上要吃早饭");
    }
}
