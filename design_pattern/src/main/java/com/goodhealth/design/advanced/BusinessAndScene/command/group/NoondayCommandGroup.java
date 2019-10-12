package com.goodhealth.design.advanced.BusinessAndScene.command.group;

import com.goodhealth.design.advanced.BusinessAndScene.command.Command;
import com.goodhealth.design.advanced.BusinessAndScene.command.MonitorCommand;
import com.goodhealth.design.advanced.BusinessAndScene.command.TeacherCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NoondayCommandGroup
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 19:43
 * @Version 1.0
 **/
public class NoondayCommandGroup extends AbstractCommandGroup {

    @Override
    public List<Command> getOthersCommand() {
        List<Command> commands = new ArrayList<>();
        commands.add(new MonitorCommand());
        commands.add(new TeacherCommand());
        return commands;
    }
}
