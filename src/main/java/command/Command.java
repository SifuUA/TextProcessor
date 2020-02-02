package command;

import java.util.Optional;

public interface Command {
    Optional<String> process(String input);
}
