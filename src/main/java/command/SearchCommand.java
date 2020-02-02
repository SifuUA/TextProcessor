package command;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.Util.TEXT;

public class SearchCommand implements Command {

    @Override
    public Optional<String> process(String input) {
        String result = Stream.of(TEXT)
                .filter(word -> word.contains(getClearInput(input)))
                .collect(Collectors.joining(" "));

        return Optional.of(result);
    }

    private String getClearInput(String input) {
        return input.replaceFirst("search", "")
                .replaceFirst("s", "")
                .strip()
                .toLowerCase();
    }
}
