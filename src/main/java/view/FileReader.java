package view;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements ReaderStrategy {
    @Override
    public String readInput() {
        var data = "";
        try {
            var text = Paths.get(this.getClass().getClassLoader().getResource("text").toURI());
            Stream<String> lines = Files.lines(text);
            data = lines.collect(Collectors.joining("\n"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
