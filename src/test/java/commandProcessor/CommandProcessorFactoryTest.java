package commandProcessor;

import command.Command;
import command.CommandAndParameters;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorFactoryTest {

    @Test
    void shouldReturnSearchCommand() {
        Command command = Command.SEARCH;
        var commandAndParameters = new CommandAndParameters(command, List.of("old"));

        assertTrue(commandAndParameters.getCommand().equals(Command.SEARCH));
    }

    @Test
    void shouldReturnTargetWord() {
        Command command = Command.SEARCH;
        var commandAndParameters = new CommandAndParameters(command, List.of("old"));

        assertTrue(commandAndParameters.getParameters().get(0).equals("old"));
    }

    @Test
    void shouldReturnSearchCommandProcessor() {
        CommandProcessorFactory commandProcessor = new CommandProcessorFactory();

        assertTrue(commandProcessor.getCommand("search old") instanceof SearchCommandProcessor);
    }


}