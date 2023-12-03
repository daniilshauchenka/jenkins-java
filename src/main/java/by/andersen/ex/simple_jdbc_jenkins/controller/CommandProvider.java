package by.andersen.ex.simple_jdbc_jenkins.controller;
import by.andersen.ex.simple_jdbc_jenkins.controller.commandImpl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.GO_TO_BASE_PAGE, new GoToBasePage());
        commands.put(CommandName.GO_TO_ADD_USER, new GoToAddUser());
        commands.put(CommandName.DO_ADD_USER, new DoAddUser());
        commands.put(CommandName.GO_TO_EDIT_USER, new GoToEditUser());
        commands.put(CommandName.DO_EDIT_USER, new DoEditUser());
        commands.put(CommandName.DO_DELETE_USER, new DoDeleteUser());
    }

    public Command getCommand(String name) {
        CommandName commandName = CommandName.GO_TO_BASE_PAGE;
        try {
            if (name != null) {
                commandName = CommandName.valueOf(name.toUpperCase());
            }
        } catch (IllegalArgumentException ignored) {
        }
        return commands.get(commandName);
    }

}
