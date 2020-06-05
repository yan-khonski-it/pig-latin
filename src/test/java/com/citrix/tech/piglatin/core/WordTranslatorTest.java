package com.citrix.tech.piglatin.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordTranslatorTest {

    WordTranslator wordTranslator = new WordTranslator();

    @Test
    public void shouldFailWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            //noinspection ConstantConditions
            wordTranslator.translate(null);
        });
    }

    @Test
    public void shouldTranslateEnglishWordEndingWithWay() {
        String text1 = "way";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1, text1);

        String text2 = "freeway";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2, text2);
    }

    @Test
    public void shouldTranslateEnglishWordEndingWithWayAndCapitalization() {
        String text1 = "wAy";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1, text1);

        String text2 = "freeWay";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2, text2);
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithNoEnglish() {
        String text1 = "+ala";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1, text1);

        String text2 = "пhi";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2, text2);
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithVowel() {
        String text1 = "apple";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1.toString(), "appleway");

        String text2 = "a";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2.toString(), "away");
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithVowelAndCapitalization() {
        String text1 = "Apple";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1.toString(), "Appleway");

        String text2 = "A";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2.toString(), "Away");

        String text3 = "anOrange";
        CharSequence translated3 = wordTranslator.translateEnglishWord(text3);

        assertEquals(translated3.toString(), "anOrangeway");
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithConsonant() {
        String text1 = "table";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1.toString(), "abletay");

        String text2 = "wayn";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2.toString(), "aynway");
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithConsonantAndCapitalization() {
        String text1 = "PAper";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1.toString(), "APerpay");

        String text2 = "P";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2.toString(), "Pay");

        String text3 = "stArWars";
        CharSequence translated3 = wordTranslator.translateEnglishWord(text3);

        assertEquals(translated3.toString(), "taRwArssay");
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithYAsVowel() {
        String text = "yc";
        CharSequence translated = wordTranslator.translateEnglishWord(text);

        assertEquals(translated.toString(), "ycway");
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithYAsVowelAndCapitalization() {
        String text1 = "YMcA";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1.toString(), "YMcAway");
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithYAsConsonant() {
        String text1 = "yellow";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1.toString(), "ellowyay");

        String text2 = "y";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2.toString(), "yay");

        String text3 = "y2";
        CharSequence translated3 = wordTranslator.translateEnglishWord(text3);

        assertEquals(translated3.toString(), "2yay");
    }

    @Test
    public void shouldTranslateEnglishWordStartingWithYAsConsonantAndCapitalization() {
        String text1 = "yellowMac";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1.toString(), "ellowmAcyay");

        String text2 = "Y";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2.toString(), "Yay");

        String text3 = "y2A";
        CharSequence translated3 = wordTranslator.translateEnglishWord(text3);

        assertEquals(translated3.toString(), "2aYay");
    }

    @Test
    public void shouldNotTranslateWordsStartingWithNoEnglish() {
        String text1 = "ЯwAy";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);

        assertEquals(translated1, text1);

        String text2 = "4freeWay";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);

        assertEquals(translated2, text2);
    }

    @Test
    public void shouldTranslateWordsWithPunctuation() {
        String text1 = "can’t";
        CharSequence translated1 = wordTranslator.translateEnglishWord(text1);
        assertEquals("antca’y", translated1.toString());

        String text2 = "can't";
        CharSequence translated2 = wordTranslator.translateEnglishWord(text2);
        assertEquals( "antca'y", translated2.toString());

        String text3 = "end.";
        CharSequence translated3 = wordTranslator.translateEnglishWord(text3);
        assertEquals( "endway.", translated3.toString());

        // TODO - check requirement. Depending on priority capitalization and punctuation, this result can be different.
        String text4 = "end.Can't!Nothing?";
        CharSequence translated4 = wordTranslator.translateEnglishWord(text4);
        assertEquals("endcAn.tno't!hingway?", translated4.toString());

        String text5 = "McDogla's!";
        CharSequence translated5 = wordTranslator.translateEnglishWord(text5);
        assertEquals("CdOglasma'y!", translated5.toString());
    }
}