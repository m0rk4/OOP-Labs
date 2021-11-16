package by.bsuir.m0rk4.oop.task.fifth.core.util;

public class ExtensionReplacer {

    private static final String EXT_PATTERN = "(?<!^)[.][^.]*$";

    public static String replace(String source, String extension) {
        return source.replaceAll(EXT_PATTERN, extension);
    }
}
