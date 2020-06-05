package com.citrix.tech.piglatin.core;

import com.citrix.tech.piglatin.utils.EnglishCharacterUtils;
import com.citrix.tech.piglatin.utils.PunctuationUtils;

import static com.citrix.tech.piglatin.utils.CapitalizationUtil.applyCapitalization;
import static com.citrix.tech.piglatin.utils.EnglishCharacterUtils.wordStartsWithConsonant;
import static com.citrix.tech.piglatin.utils.EnglishCharacterUtils.wordStartsWithVowel;
import static com.citrix.tech.piglatin.utils.PunctuationUtils.applyPunctuation;

/**
 * Translates word into Pig Latin.
 *
 * Method returns a {@link CharSequence} which can be a {@link String} - unchanged word if translation failed;
 * or {@link StringBuilder} - translated word.
 * {@link StringBuilder} can be later modified to apply capitalization rules;
 * otherwise, I'd have to create a new object.
 */
class WordTranslator {

    private static final String WAY = "way";
    private static final String AY = "ay";


    protected WordTranslator() {
    }

    /**
     * @param word - not null word.
     * @return translated word.
     */
    public CharSequence translate(final String word) {
        if (word.isEmpty()) {
            return "";
        }

        // Do not translate not English words because we do not know how.
        // Also it can be a space, separator, etc.
        if (EnglishCharacterUtils.noEnglishCharacters(word)) {
            return word;
        }

        return translateEnglishWord(word);
    }

    /**
     * Translates English word.
     */
    protected CharSequence translateEnglishWord(final String word) {
        final String lowerCasedWord = word.toLowerCase();

        if (lowerCasedWord.endsWith(WAY)) {
            return word;
        }

        final String lowerCasedWithoutPunctuation = PunctuationUtils.removePunctuation(lowerCasedWord);

        if (wordStartsWithConsonant(lowerCasedWithoutPunctuation)) {
            final StringBuilder wordWithMovedLetters = moveFirstLetterToTheEndAndAppendAy(lowerCasedWithoutPunctuation);
            return applyRules(word, wordWithMovedLetters);
        } else if (wordStartsWithVowel(lowerCasedWithoutPunctuation)) {
            final StringBuilder wordWithMovedLetters = appendWayToTheEnd(lowerCasedWithoutPunctuation);
            return applyRules(word, wordWithMovedLetters);
        }

        // We do not know how to translate words that start with neither a vowel or a consonant.
        return word;
    }

    private CharSequence applyRules(final String word, final StringBuilder stringBuilder) {
        // TODO What has higher priority: capitalization or punctuation?
        // In the task description, capitalization requirement was after punctuation,
        // so I gave capitalization a lower priority.
        applyPunctuation(word, stringBuilder);
        applyCapitalization(word, stringBuilder);
        return stringBuilder;
    }

    /**
     * A word starts with a consonant. Move it to the end of the word and append 'ay'.
     * It returns a {@link StringBuilder} because we can change it later.
     */
    private StringBuilder moveFirstLetterToTheEndAndAppendAy(final String lowerCasedWord) {
        return new StringBuilder(lowerCasedWord.substring(1)).append(lowerCasedWord.charAt(0)).append(AY);
    }

    /**
     * A word starts with a vowel. Append 'way' to the end.
     */
    private StringBuilder appendWayToTheEnd(final String lowerCasedWord) {
        return new StringBuilder(lowerCasedWord).append(WAY);
    }
}
