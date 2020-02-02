package command;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static util.Util.TEXT;

public class MapCommand implements Command {
    @Override
    public Optional<String> process(String input) {
        var inputWithNoMap = input.replaceFirst("map", "");
        var commandParts = Arrays.stream(inputWithNoMap.split(" "))
                .filter(s -> !s.isBlank())
                .collect(toList());

        return mapByParameters(commandParts);
    }

    private Optional<String> mapByParameters(List<String> commandParts) {
        var size = commandParts.size();
        if (size == 1) {
            return mapByOneParameter(commandParts);
        }
        return mapByManyParameters(commandParts);
    }

    private Optional<String> mapByOneParameter(List<String> commandParts) {
        var parameter = commandParts.get(0);

        if (parameter.equals("up")) {
            String result = Arrays.stream(TEXT)
                    .map(String::toUpperCase)
                    .collect(joining(" "));

            return Optional.of(result);
        }
        return Optional.empty();
    }

    private Optional<String> mapByManyParameters(List<String> commandParts) {
        var wordToMap = commandParts.get(0);
        var mapCriteria = commandParts.get(1);

        if (mapCriteria.equals("up")) {
            var result = Arrays.stream(String.join(" ", TEXT)
                    .split(" "))
                    .filter(s -> !s.isBlank())
                    .map(s -> s.equalsIgnoreCase(wordToMap) ? wordToMap.toUpperCase() : s)
                    .collect(joining(" "));
            return of(result);
        }
        return empty();
    }
}
