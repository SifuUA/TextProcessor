package util;

import reader.FileReader;

import java.util.function.Predicate;

public final class Util {

    private Util() {
    }

    public static final Predicate<String> NON_BLANK = s -> !s.isBlank();

    public static final String SPACE = " ";

    public static final String[] TEXT = getText();

    public static String[] getText() {
        return new FileReader().read()
                .split("\\W+");
    }

}
