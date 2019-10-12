package com.goodhealth.design.advanced.BusinessAndScene.ationChain.action;

import com.goodhealth.design.advanced.BusinessAndScene.ActionEnum;
import com.goodhealth.design.advanced.BusinessAndScene.command.Command;
import com.goodhealth.design.advanced.BusinessAndScene.command.group.AfternoonCommandGroup;
import org.springframework.stereotype.Component;

/**
 * @ClassName AfternoonAction
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 21:10
 * @Version 1.0
 **/
@Component
public class AfternoonAction extends AbstractAction {


    @Override
    public ActionEnum getActionEnum() {
        return ActionEnum.AFTERNOON;
    }

    @Override
    public Command getCommandGroup() {
        return new AfternoonCommandGroup();
    }
}
