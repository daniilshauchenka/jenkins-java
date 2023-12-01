package by.andersen.ex.simple_jdbc_jenkins.controller;

import by.andersen.ex.simple_jdbc_jenkins.controller.commandImpl.GoToBasePage;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.GO_TO_BASE_PAGE, new GoToBasePage());
    }

    public Command getCommand(String name) {
        CommandName  commandName = CommandName.GO_TO_BASE_PAGE;
        try {
            if(name!=null) {
                commandName = CommandName.valueOf(name.toUpperCase());
            }
        } catch(IllegalArgumentException ignored) {}
        return commands.get(commandName);
    }

}
