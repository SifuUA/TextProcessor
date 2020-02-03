package reader;

import java.util.Scanner;

public class ConsoleReader implements ReaderStrategy {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine().strip();
    }

}
