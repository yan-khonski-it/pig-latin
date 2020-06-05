package com.citrix.tech.piglatin.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PigLatinTranslatorTest {

    // Subject
    private final PigLatinTranslator pigLatinTranslator = PigLatinTranslator.defaultInstance();

    @Test
    public void shouldReturnEmptyForNull() {
        String translated1 = pigLatinTranslator.translateText(null);
        assertNotNull(translated1);
        assertTrue(translated1.isEmpty());

        String translated2 = pigLatinTranslator.translateText("");
        assertNotNull(translated2);
        assertTrue(translated2.isEmpty());
    }

    @Test
    public void shouldTranslateText() {
        String text = "Hi there! I'm waiting for you. Can't way no-more: did you hear the LaTeSt_news?";
        String translated = pigLatinTranslator.translateText(text);
        String expected = "Ihay heretay! Imwa'y aitingway orfay ouyay. " +
                "Antca'y way onay-oremay: idday ouyay earhay hetay AtEsT_newslay?";

        assertEquals(expected, translated);
    }
}