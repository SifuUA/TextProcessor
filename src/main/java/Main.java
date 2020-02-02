import command.CommandFactory;
import reader.ConsoleReader;

public class Main {

    public static void main(String[] args) {
        var commandFactory = new CommandFactory();
        var consoleReader = new ConsoleReader();

        System.out.println("Enter command:");
        var input = consoleReader.readInput();

        commandFactory.getCommand(input)
                .flatMap(command -> command.process(input))
                .ifPresent(System.out::println);
    }
}
