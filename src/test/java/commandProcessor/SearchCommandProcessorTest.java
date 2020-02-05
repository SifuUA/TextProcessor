package commandProcessor;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchCommandProcessorTest {

    @Test
    void shouldReturnOptionalEmpty() {
        var searchCommandProcessor = new SearchCommandProcessor(List.of());
        Optional<String> result = searchCommandProcessor.process();
        assertEquals(Optional.empty(), result);
    }

    @Test
    void shouldReturnNotEmptyOptional() {
        var searchCommandProcessor = new SearchCommandProcessor(List.of("old"));
        Optional<String> result = searchCommandProcessor.process();
        assertEquals(Optional.of("cold old hold old"), result);
    }
}