package command;

import java.util.Collections;
import java.util.List;

public class CommandAndParameters {

    private Command command;
    private List<String> parameters;

    public CommandAndParameters(Command command, List<String> parameters) {
        this.command = command;
        this.parameters = Collections.unmodifiableList(parameters);
    }

    public Command getCommand() {
        return command;
    }

    public List<String> getParameters() {
        return parameters;
    }

}
