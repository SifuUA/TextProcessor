package commandProcessor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static util.Util.*;

public class SearchCommandProcessor implements CommandProcessor {

    private final List<String> parameters;

    public SearchCommandProcessor(List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public Optional<String> process() {
        return parameters.isEmpty() ? Optional.empty() : allSuperStringsFor(parameters.get(0));
    }

    private Optional<String> allSuperStringsFor(String enclosingWord) {
        var result = Stream.of(TEXT)
                .filter(NON_BLANK)
                .filter(word -> word.contains(enclosingWord))
                .collect(Collectors.joining(SPACE));

        return result.isBlank() ? Optional.of("No results") : Optional.of(result);
    }

}
