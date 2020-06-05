package com.citrix.tech.piglatin.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalizationUtilTest {

    @Test
    public void shouldApplyCapitalization() {
        String word1 = "abc";
        StringBuilder stringBuilder1 = new StringBuilder("abc");
        CapitalizationUtil.applyCapitalization(word1, stringBuilder1);

        assertEquals(stringBuilder1.toString(), word1);

        String word2 = "llllUllllllUl";
        StringBuilder stringBuilder2 = new StringBuilder("somestrangestring");
        CapitalizationUtil.applyCapitalization(word2, stringBuilder2);

        assertEquals(stringBuilder2.toString(), "someStrangeString");
    }
}