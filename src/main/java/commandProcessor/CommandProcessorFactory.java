package commandProcessor;

import command.Command;
import command.CommandAndParameters;

public class CommandProcessorFactory {

    public CommandProcessor getCommand(String command) {
        var commandAndParameters = Command.mapToCommandAndParameters(command);

        return mapToCommandProcessor(commandAndParameters);
    }

    private CommandProcessor mapToCommandProcessor(CommandAndParameters commandAndParameters) {
        var command = commandAndParameters.getCommand();
        var parameters = commandAndParameters.getParameters();

        switch (command) {
            case MAP:
                return new MapCommandProcessor(parameters);
            case SEARCH:
                return new SearchCommandProcessor(parameters);
            case COUNT:
                return new CountCommandProcessor(parameters);
            default:
                return new IllegalCommandProcessor();
        }
    }

}
