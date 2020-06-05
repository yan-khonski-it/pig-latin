package com.citrix.tech.piglatin.core;

import org.apache.commons.lang3.StringUtils;

import static com.citrix.tech.piglatin.utils.CompoundWordUtils.isCompoundWord;
import static com.citrix.tech.piglatin.utils.CompoundWordUtils.splitMapAndJoinCompoundWord;
import static com.citrix.tech.piglatin.utils.TextUtils.splitTextWithSpacesPreserved;

/**
 * Translates ENGLISH text into Pig Latin.
 * <p>
 * This translator is thread safe.
 */
public class PigLatinTranslator {

    private final WordTranslator wordTranslator;

    protected PigLatinTranslator(final WordTranslator wordTranslator) {
        this.wordTranslator = wordTranslator;
    }

    public static PigLatinTranslator defaultInstance() {
        final WordTranslator wordTranslator = new WordTranslator();
        return new PigLatinTranslator(wordTranslator);
    }

    public String translateText(final String text) {
        if (StringUtils.isEmpty(text)) {
            return "";
        }

        final StringBuilder translatedText = new StringBuilder();
        final String[] words = splitTextWithSpacesPreserved(text);

        for (String word : words) {
            final CharSequence translatedWord = translate(word);
            translatedText.append(translatedWord);
        }

        return translatedText.toString();
    }

    private CharSequence translate(final String word) {
        if (isCompoundWord(word)) {
            return splitMapAndJoinCompoundWord(word, wordTranslator::translate);
        } else {
            return wordTranslator.translate(word);
        }
    }
}
