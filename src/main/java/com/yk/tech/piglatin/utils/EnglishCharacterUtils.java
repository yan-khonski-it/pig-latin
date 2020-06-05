package com.yk.tech.piglatin.utils;

import java.util.Set;

/**
 * Encapsulates logic to work with English characters.
 * We need to distinguish vowels from consonants.
 */
public final class EnglishCharacterUtils {

    protected static final String ABC_LOWER_CASED = "abcdefghijklmnopqrstuvwxyz";

    private static final String ABC = ABC_LOWER_CASED + ABC_LOWER_CASED.toUpperCase();

    private static final String VOWEL_LETTERS = "aeiou";
    private static final String CONSONANT_LETTERS = "bcdfghjklmnpqrstvwxz";


    // English letters
    private static final Set<Character> LETTERS = CharUtils.initCharacters(ABC);

    // Vowels
    // https://simple.wikipedia.org/wiki/Vowel
    private static final Set<Character> VOWELS = CharUtils.initCharacters(VOWEL_LETTERS);

    // Consonants
    // https://simple.wikipedia.org/wiki/Consonant
    private static final Set<Character> CONSONANTS = CharUtils.initCharacters(CONSONANT_LETTERS);

    // Y - can be both a vowel and a consonant.
    // We are interested in cases where a word starts with Y.
    // If the second letter of the word is a vowel, then Y is a consonant.
    // For example, yOu, yEllow
    // https://www.thefreedictionary.com/words-that-start-with-y
    // However, if the second letter of the word is a consonant, then y sounds as vowel
    // https://www.thefreedictionary.com/words-that-start-with-yt
    // For example, yclept, yttric
    private static final Character Y = 'y';

    private EnglishCharacterUtils() {
        throw new IllegalStateException("No instance is allowed.");
    }

    /**
     * @return {@code true} if and only if the {@code word} starts with vowel.
     */
    public static boolean wordStartsWithVowel(final String word) {
        final char ch0 = word.charAt(0);
        if (ch0 == Y) {
            return isYVowel(word);
        }

        return VOWELS.contains(ch0);
    }

    /**
     * @return {@code true} if and only if the {@code word} starts with vowel.
     */
    public static boolean wordStartsWithConsonant(final String word) {
        final char ch0 = word.charAt(0);
        if (ch0 == Y) {
            return isYConsonant(word);
        }

        return CONSONANTS.contains(ch0);
    }

    /**
     * @return {@code true} if given {@code word} does not contain English characters.
     */
    public static boolean noEnglishCharacters(final String word) {
        final char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (LETTERS.contains(ch)) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return {@code true} if given {@code word} starts with {@code y} which is a vowel.
     */
    private static boolean isYVowel(final String word) {
        return word.length() >= 2 && CONSONANTS.contains(word.charAt(1));
    }

    /**
     * @return {@code true} if given {@code word} starts with {@code y} which is a consonant.
     */
    private static boolean isYConsonant(final String word) {
        return word.length() == 1 || !CONSONANTS.contains(word.charAt(1));
    }
}
