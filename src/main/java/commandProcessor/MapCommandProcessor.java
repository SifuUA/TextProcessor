package commandProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static util.Util.*;

public class MapCommandProcessor implements CommandProcessor {

    private List<String> parameters;

    public MapCommandProcessor(List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public Optional<String> process() {
        var size = parameters.size();
        if (size == 1) {
            return mapByOneParameter(parameters);
        }
        return mapByManyParameters(parameters);
    }

    private Optional<String> mapByOneParameter(List<String> parameters) {
        var parameter = parameters.get(0);

        if (parameter.equals("up")) {
            String result = Arrays.stream(TEXT)
                    .map(String::toUpperCase)
                    .collect(joining(SPACE));

            return Optional.of(result);
        }
        return Optional.of("Illegal flag passed");
    }

    private Optional<String> mapByManyParameters(List<String> parameters) {
        var wordToMap = parameters.get(0);
        var mapCriteria = parameters.get(1);

        if (mapCriteria.equals("up")) {
            return mapSubstringToUppercase(wordToMap);
        }

        return Optional.of("Illegal flag passed");
    }

    private Optional<String> mapSubstringToUppercase(String wordToMap) {
        var result = Arrays.stream(TEXT)
                .filter(NON_BLANK)
                .map(s -> s.equalsIgnoreCase(wordToMap) ? wordToMap.toUpperCase() : s)
                .collect(joining(SPACE));
        return Optional.of(result);
    }

}
