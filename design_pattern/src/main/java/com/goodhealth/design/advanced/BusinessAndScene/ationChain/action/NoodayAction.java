package com.goodhealth.design.advanced.BusinessAndScene.ationChain.action;

import com.goodhealth.design.advanced.BusinessAndScene.ActionEnum;
import com.goodhealth.design.advanced.BusinessAndScene.command.Command;
import com.goodhealth.design.advanced.BusinessAndScene.command.group.NoondayCommandGroup;
import org.springframework.stereotype.Component;

/**
 * @ClassName NoodayAction
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 21:11
 * @Version 1.0
 **/
@Component
public class NoodayAction extends AbstractAction {

    @Override
    public ActionEnum getActionEnum() {
        return ActionEnum.NOONDAY;
    }

    @Override
    public Command getCommandGroup() {
        return new NoondayCommandGroup();
    }
}
