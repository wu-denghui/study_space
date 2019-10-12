package com.goodhealth.design.advanced.BusinessAndScene.command.group;

import com.goodhealth.design.advanced.BusinessAndScene.command.Command;
import com.goodhealth.design.advanced.BusinessAndScene.command.MotherCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AbstractCommandGroup
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 19:44
 * @Version 1.0
 **/
public abstract class AbstractCommandGroup implements Command {

    abstract List<Command>  getOthersCommand();

    @Override
    public void  ation(){
        List<Command> parentCommands = getParentCommand();
        List<Command> othersCommands = getOthersCommand();
        parentCommands.addAll(othersCommands);
        for (Command c :parentCommands) {
            c.ation();
        }
    }

    private List<Command> getParentCommand(){
        List<Command> commands = new ArrayList<>();
        commands.add(new MotherCommand());
        return commands;
    }
}
