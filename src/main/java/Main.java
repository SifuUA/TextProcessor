import commandProcessor.CommandProcessorFactory;
import reader.ConsoleReader;

public class Main {

    public static void main(String[] args) {
        var commandFactory = new CommandProcessorFactory();
        var consoleReader = new ConsoleReader();

        do {
            System.out.println("Enter command:");
            var input = consoleReader.read();

            commandFactory.getCommand(input)
                    .process()
                    .ifPresent(System.out::println);
        } while (shouldContinue(consoleReader));
    }

    private static boolean shouldContinue(ConsoleReader consoleReader) {
        System.out.println("Should continue?(y/n)");
        return checkAnswer(consoleReader.read());
    }

    private static boolean checkAnswer(String answer) {
        return answer.equals("y");
    }

}
