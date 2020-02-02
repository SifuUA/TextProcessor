package reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileReader implements ReaderStrategy {
    @Override
    public String readInput() {
        var data = "";
        try {
            data = Files.lines(
                    Paths.get(this.getClass().getClassLoader().getResource("text").toURI()))
                    .collect(Collectors.joining("\n"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
