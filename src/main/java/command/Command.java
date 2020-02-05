package command;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.Set.of;
import static java.util.stream.Collectors.toList;
import static util.Util.NON_BLANK;
import static util.Util.SPACE;

public enum Command {

    MAP(of("map", "m")),
    SEARCH(of("search", "s")),
    COUNT(of("count", "c")),

    ILLEGAL(of());

    final Set<String> codes;

    Command(Set<String> codes) {
        this.codes = codes;
    }

    public static CommandAndParameters mapToCommandAndParameters(String input) {
        var inputParts = recognizeCommandAndParameters(input);

        if (inputParts.isEmpty()) {
            return illegal();
        } else {
            return commandAndParameters(inputParts);
        }
    }

    private static CommandAndParameters illegal() {
        return new CommandAndParameters(ILLEGAL, List.of());
    }

    private static CommandAndParameters commandAndParameters(List<String> inputParts) {
        var command = mapToCommand(inputParts.get(0));
        return new CommandAndParameters(command, inputParts.subList(1, inputParts.size()));
    }

    private static List<String> recognizeCommandAndParameters(String input) {
        return Arrays.stream(input.split(SPACE))
                .filter(NON_BLANK)
                .collect(toList());
    }

    private static Command mapToCommand(String input) {
        return Arrays.stream(values())
                .filter(command -> command.codes.contains(input))
                .findAny().orElse(ILLEGAL);
    }

}
