import view.ConsoleReader;
import view.ReaderStrategy;

public class Main {
    public static void main(String[] args) {
        ReaderStrategy consoleReader = new ConsoleReader();
        System.out.println("Please input command:");
        String input = consoleReader.readInput();

        if (input.startsWith("map") || input.startsWith("m")) {
            map(input);
        } else if (input.startsWith("filter") || input.startsWith("f")) {
            filter(input);
        } else {
            System.out.println("Command not recognized.");
        }
    }

    private static void filter(String input) {

    }

    private static void map(String input) {
    }
}
