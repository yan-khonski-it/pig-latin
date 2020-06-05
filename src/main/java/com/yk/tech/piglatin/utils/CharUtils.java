package com.yk.tech.piglatin.utils;

import java.util.HashSet;
import java.util.Set;

public final class CharUtils {

    private CharUtils() {
        throw new IllegalStateException("No instance is allowed.");
    }

    /**
     * Builds a set of unique characters from given {@code characters} String.
     * It is more convenient to search if a character is present in a set than in a String.
     */
    public static Set<Character> initCharacters(final String characters) {
        final Set<Character> res = new HashSet<>();
        final char[] chars = characters.toCharArray();
        for (char ch : chars) {
            res.add(ch);
        }

        return res;
    }
}
