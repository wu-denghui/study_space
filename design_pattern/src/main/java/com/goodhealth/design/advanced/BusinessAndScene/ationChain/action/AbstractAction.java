package com.goodhealth.design.advanced.BusinessAndScene.ationChain.action;

import com.goodhealth.design.advanced.BusinessAndScene.ActionEnum;
import com.goodhealth.design.advanced.BusinessAndScene.command.Command;


/**
 * @ClassName AbstractAction
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 21:07
 * @Version 1.0
 **/
public abstract class AbstractAction {

    abstract public ActionEnum getActionEnum();

    abstract public Command getCommandGroup();

    public void act(){
        getCommandGroup().ation();
    }
}
