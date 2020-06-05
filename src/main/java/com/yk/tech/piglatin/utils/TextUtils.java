package com.yk.tech.piglatin.utils;

import java.util.regex.Pattern;

/**
 * Splits text into tokens.
 */
public final class TextUtils {

    // https://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters/2206432
    private static final String SPLIT_SPACE_REGEX = "((?<=\\s)|(?=\\s))";
    private static final Pattern SPLIT_SPACE_PATTERN = Pattern.compile(SPLIT_SPACE_REGEX);

    private TextUtils() {
        throw new IllegalStateException("No instance is allowed.");
    }

    /**
     * Splits given {@code text} into words preserving spaces.
     */
    public static String[] splitTextWithSpacesPreserved(final String text) {
        return SPLIT_SPACE_PATTERN.split(text);
    }
}
