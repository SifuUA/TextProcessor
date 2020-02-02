package util;

import reader.FileReader;

public final class Util {
    private Util() {
    }

    public static final String FILE_NAME = "resources/text";

    public static final String[] TEXT = getText();

    public static String[] getText() {
        return new FileReader()
                .readInput()
                .split("\\W+");
    }

}
