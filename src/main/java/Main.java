import commandProcessor.CommandProcessorFactory;
import reader.ConsoleReader;

public class Main {

    public static void main(String[] args) {
        var commandFactory = new CommandProcessorFactory();
        var consoleReader = new ConsoleReader();

        System.out.println("Enter command:");
        var input = consoleReader.read();

        commandFactory.getCommand(input).process().ifPresent(System.out::println);
//                .flatMap(command -> command.process(input))
//                .ifPresentOrElse(System.out::println, () -> System.out.println("No results."));
    }

}
