package commandProcessor;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.Util.NON_BLANK;
import static util.Util.TEXT;

public class CountCommandProcessor implements CommandProcessor {

    private List<String> parameters;

    private final Predicate<String> isWantedWord = (word) -> parameters.contains(word);
    private final Predicate<String> allWordsAreSuitable = (word) -> true;
    private final Predicate<String> isPartialWord = (word) -> word.contains(parameters.get(0));

    public CountCommandProcessor(List<String> parameters) {
        this.parameters = new ArrayList<>(parameters);
    }

    @Override
    public Optional<String> process() {
        var textHolder = Stream.of(TEXT)
                .toArray(String[]::new);

        return count(textHolder);
    }

    private Optional<String> count(String[] text) {
        Optional<String> result = Optional.empty();
        if (!parameters.isEmpty()) {
            text = checkIgnoreCaseFlag(text);

            result = countWithPartialWordFlag(text, result);

            result = countWithWordParameter(text, result);
        }
        return result.isPresent() ? result : count(allWordsAreSuitable, text);
    }

    private Optional<String> countWithWordParameter(String[] text, Optional<String> result) {
        if (isWordParameterPresent()){
            result = count(isWantedWord, text);
        }
        return result;
    }

    private Optional<String> countWithPartialWordFlag(String[] text, Optional<String> result) {
        if (checkPartialWordFlag()) {
            result = count(isPartialWord, text);
        }
        return result;
    }

    private boolean isWordParameterPresent() {
        return !parameters.isEmpty();
    }

    private boolean checkPartialWordFlag() {
        if (parameters.contains("p")) {
            parameters.remove("p");
            return true;
        }
        return false;
    }

    private String[] checkIgnoreCaseFlag(String[] text) {
        if (parameters.contains("ic")) {
            parameters.remove("ic");
            text = toLowerCase(text);
            parameters = toLowerCase(parameters);
        }
        return text;
    }

    private List<String> toLowerCase(List<String> parameters) {
        return parameters.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    private String[] toLowerCase(String[] text) {
        return Stream.of(text)
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }

    private Optional<String> count(Predicate<String> isWantedWord, String[] text) {
        var result = Stream.of(text)
                .filter(NON_BLANK)
                .filter(isWantedWord)
                .count();
        return Optional.of(String.valueOf(result));
    }
}
