package com.yk.tech.piglatin.utils;

/**
 * Util to make capital letters in a word.
 */
public final class CapitalizationUtil {

    private CapitalizationUtil() {
        throw new IllegalStateException("No instance is allowed.");
    }

    /**
     * Makes UPPER_CASE characters in {@code lowerCasedWord} at the positions as they are in {@code word}.
     * Note, {@code lowerCasedWord} should have greater and same lenght as {@code word}.
     */
    public static void applyCapitalization(final String word, final StringBuilder lowerCasedWord) {
        final int length = word.length();
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitalizeCharacterAt(lowerCasedWord, i);
            }
        }
    }

    /**
     * Converts to UPPER_CASE character at given {@code position}.
     */
    private static void capitalizeCharacterAt(final StringBuilder stringBuilder, final int position) {
        final char ch = stringBuilder.charAt(position);
        final char capitalizedChar = Character.toUpperCase(ch);
        stringBuilder.setCharAt(position, capitalizedChar);
    }
}
