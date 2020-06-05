package com.citrix.tech.piglatin.utils;

import java.util.Set;

import static com.citrix.tech.piglatin.utils.CharUtils.initCharacters;

/**
 * Util class to handle punctuation requirements.
 */
public final class PunctuationUtils {

    /**
     * https://grammar.yourdictionary.com/punctuation/what/fourteen-punctuation-marks.html
     * <p>
     * https://en.wikipedia.org/wiki/Dash
     * <p>
     * Note, this is not standard English punctuation. We handle hyphens separately in {@link CompoundWordUtils}.
     */
    private static final String PUNCTUATION_CHARACTERS = ".?!,;:–—―(){}[]\"'’";

    private static final Set<Character> PUNCTUATIONS = initCharacters(PUNCTUATION_CHARACTERS);

    private PunctuationUtils() {
        throw new IllegalStateException("No instance is allowed.");
    }

    /**
     * Removes punctuations from given {@code word}.
     */
    public static String removePunctuation(final String word) {
        final StringBuilder res = new StringBuilder();
        final char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!PUNCTUATIONS.contains(ch)) {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void applyPunctuation(final String word, final StringBuilder noPunctuationWord) {
        final int length = word.length();
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(length - 1 - i);
            if (PUNCTUATIONS.contains(ch)) { // is punctuation?
                insertCharAtFromTheEnd(noPunctuationWord, ch, i);
            }
        }
    }

    private static void insertCharAtFromTheEnd(final StringBuilder stringBuilder,
                                                   final char ch,
                                                   final int position) {
        final int length = stringBuilder.length();
        stringBuilder.insert(length - position, ch);
    }
}
