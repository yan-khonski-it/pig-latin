package com.yk.tech.piglatin.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TextUtilsTest {

    @Test
    public void shouldFailToSplitNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            TextUtils.splitTextWithSpacesPreserved(null);
        });
    }

    @Test
    public void shouldSplitEmpty() {
        String[] words = TextUtils.splitTextWithSpacesPreserved("");

        assertEquals(words.length, 1);
        assertEquals(words[0], "");
    }

    @Test
    public void shouldSplitText() {
        String text = "Hi there!\nMy best regards.\n\rCheers and  health!Forgot-to-say bye – bye.I " +
                "can't can’t wait for+you! Bye-bye";
        String[] expected = {"Hi", " ", "there!", "\n", "My", " ", "best", " ", "regards.", "\n", "\r", "Cheers", " ",
                "and", " ", " ", "health!Forgot-to-say", " ", "bye", " ", "–", " ", "bye.I",
                " ", "can't", " ", "can’t", " ", "wait", " ", "for+you!", " ", "Bye-bye"};

        String[] words = TextUtils.splitTextWithSpacesPreserved(text);

        assertArrayEquals(expected, words);
    }
}