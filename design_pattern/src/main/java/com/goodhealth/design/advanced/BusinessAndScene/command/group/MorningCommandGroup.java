package com.goodhealth.design.advanced.BusinessAndScene.command.group;

import com.goodhealth.design.advanced.BusinessAndScene.command.Command;
import com.goodhealth.design.advanced.BusinessAndScene.command.MonitorCommand;
import com.goodhealth.design.advanced.BusinessAndScene.command.MotherCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MorningCommandGroup
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 19:42
 * @Version 1.0
 **/
public class MorningCommandGroup extends AbstractCommandGroup {

    @Override
    public List<Command> getOthersCommand() {
        List<Command> commands = new ArrayList<>();
        commands.add(new MonitorCommand());
        commands.add(new MotherCommand());
        return commands;
    }
}
