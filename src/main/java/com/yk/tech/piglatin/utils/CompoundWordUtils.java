package com.yk.tech.piglatin.utils;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utils to deal with compound words (they have one or more hyphens).
 */
public final class CompoundWordUtils {

    protected static final String HYPHEN = "-";

    private CompoundWordUtils() {
        throw new IllegalStateException("No instance is allowed.");
    }

    /**
     * Splits {@code compoundWord} by hyphens,
     * applies {@code simpleWordFunction} for each part,
     * and then builds a new compound word from the applied parts.
     */
    public static String splitMapAndJoinCompoundWord(final String compoundWord,
                                                     final Function<String, CharSequence> simpleWordFunction) {
        return splitByHyphens(compoundWord)
                .map(simpleWordFunction)
                .collect(Collectors.joining(HYPHEN));
    }

    /**
     * @return {@code true} if given {@code word} contains one or more hyphens.
     */
    public static boolean isCompoundWord(final String word) {
        return word.contains(HYPHEN);
    }

    /**
     * Splits a {@code compoundWord} into a stream of simple words.
     * These words cab be later joined into a new compound word after some mapping was applied.
     */
    protected static Stream<String> splitByHyphens(final String compoundWord) {
        final String[] noHyphenWords = compoundWord.split(HYPHEN);
        return Arrays.stream(noHyphenWords);
    }
}
