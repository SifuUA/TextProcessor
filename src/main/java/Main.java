import commandProcessor.CommandProcessorFactory;
import reader.ConsoleReader;

public class Main {

    public static void main(String[] args) {
        var commandFactory = new CommandProcessorFactory();
        var consoleReader = new ConsoleReader();

        System.out.println("Enter command:");
        var input = consoleReader.read();

        commandFactory.getCommand(input)
                .process()
                .ifPresent(System.out::println);
    }

}
