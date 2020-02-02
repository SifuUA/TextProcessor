package command;

import java.util.Optional;

public class CommandFactory {
    public Optional<Command> getCommand(String command) {
        if (command.startsWith("map") || command.startsWith("m")) {
            return Optional.of(new MapCommand());
        } else if (command.startsWith("search") || command.startsWith("s")) {
            return Optional.of(new SearchCommand());
        }
        return Optional.empty();
    }
}
