package com.goodhealth.design.advanced.BusinessAndScene.ationChain.action;

import com.goodhealth.design.advanced.BusinessAndScene.ActionEnum;
import com.goodhealth.design.advanced.BusinessAndScene.command.Command;
import com.goodhealth.design.advanced.BusinessAndScene.command.group.MorningCommandGroup;
import org.springframework.stereotype.Component;

/**
 * @ClassName MorningAction
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 21:10
 * @Version 1.0
 **/
@Component
public class MorningAction extends AbstractAction {
    @Override
    public ActionEnum getActionEnum() {
        return ActionEnum.MORINING;
    }

    @Override
    public Command getCommandGroup() {
        return new MorningCommandGroup();
    }
}
