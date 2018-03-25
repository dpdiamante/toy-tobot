package dpd.whispir.robot.toyrobot.application.model;

import java.util.ArrayList;
import java.util.List;

public class Command {

    private final String command;

    private final List<String> commandParameters = new ArrayList<>();

    public Command(String command, String... parameters) {
        this.command = command.trim();

        if (parameters != null && parameters.length > 0) {
            for (String parameter : parameters) {
                this.commandParameters.add(parameter.trim());
            }
        }
    }

    public String getCommand() {
        return command;
    }

    public List<String> getCommandParameters() {
        return commandParameters;
    }
}
