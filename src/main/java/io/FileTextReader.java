package io;

import java.io.*;

import static java.util.stream.Collectors.joining;

public class FileTextReader implements TextReader {

    private final String fileName;

    public FileTextReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String read() {
        var result = "";
        try (var reader = new BufferedReader(new FileReader(new File(fileName)))) {
            result = reader.lines().collect(joining(" "));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
