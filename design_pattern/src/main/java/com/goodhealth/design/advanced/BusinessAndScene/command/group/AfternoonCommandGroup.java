package com.goodhealth.design.advanced.BusinessAndScene.command.group;

import com.goodhealth.design.advanced.BusinessAndScene.command.Command;
import com.goodhealth.design.advanced.BusinessAndScene.command.GFCommand;
import com.goodhealth.design.advanced.BusinessAndScene.command.MonitorCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AfternoonCommandGroup
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 19:44
 * @Version 1.0
 **/
public class AfternoonCommandGroup extends AbstractCommandGroup{

    @Override
    public List<Command> getOthersCommand() {
        List<Command> commands = new ArrayList<>();
        commands.add(new MonitorCommand());
        commands.add(new GFCommand());
        return commands;
    }
}
