package com.yk.tech.piglatin.core;

import com.yk.tech.piglatin.utils.CompoundWordUtils;
import org.apache.commons.lang3.StringUtils;

import static com.yk.tech.piglatin.utils.TextUtils.splitTextWithSpacesPreserved;

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
        if (CompoundWordUtils.isCompoundWord(word)) {
            return CompoundWordUtils.splitMapAndJoinCompoundWord(word, wordTranslator::translate);
        } else {
            return wordTranslator.translate(word);
        }
    }
}
