import io.FileTextReader;
import view.ConsoleReader;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {

    private static final String FILE_NAME = "/home/oleksandr/gitrepos/DreamTeam/TextProcessor/src/main/resources/text";

    public static void main(String[] args) {
        var consoleReader = new ConsoleReader();
        System.out.println("Enter command:");
        var input = consoleReader.readInput();

        if (input.startsWith("map") || input.startsWith("m")) {
            var result = map(input);
            System.out.println(result);
        } else if (input.startsWith("filter") || input.startsWith("f")) {
            filter(input);
        } else {
            System.out.println("Command not recognized.");
        }
    }

    private static void filter(String input) {

    }

    private static Optional<String> map(String input) {
        var inputWithNoMap = input.replaceFirst("map", "");
        var commandParts = Arrays.stream(inputWithNoMap.split(" ")).filter(s -> !s.isBlank()).collect(toList());

        if (isLegalMapCommand(commandParts)) {
            return mapByParameters(commandParts);
        }
        return empty();
    }

    private static Optional<String> mapByParameters(List<String> commandParts) {
        var size = commandParts.size();
        if (size == 1) {
            return mapByOneParameter(commandParts);
        }
        return mapByManyParameters(commandParts);
    }

    private static Optional<String> mapByOneParameter(List<String> commandParts) {
        var parameter = commandParts.get(0);

        if (parameter.equals("up")) {
            var text = new FileTextReader(FILE_NAME).read();
            return of(text.toUpperCase());
        }
        return empty();
    }

    private static Optional<String> mapByManyParameters(List<String> commandParts) {
        var wordToMap = commandParts.get(0);
        var mapCriteria = commandParts.get(1);

        if (mapCriteria.equals("up")) {
            var text = new FileTextReader(FILE_NAME).read();
            var result = Arrays.stream(text.split(" "))
                    .filter(s -> !s.isBlank())
                    .map(s -> s.equalsIgnoreCase(wordToMap) ? wordToMap.toUpperCase() : s)
                    .collect(joining(" "));
            return of(result);
        }
        return empty();
    }

    private static boolean isLegalMapCommand(List<String> commandParts) {
        return commandParts.size() >= 1;
    }

}
