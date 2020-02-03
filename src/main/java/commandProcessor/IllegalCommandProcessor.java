package commandProcessor;

import java.util.Optional;

public class IllegalCommandProcessor implements CommandProcessor {

    @Override
    public Optional<String> process() {
        return Optional.of("Illegal command");
    }

}
