package com.yk.tech.piglatin.utils;

import org.junit.jupiter.api.Test;

import static com.yk.tech.piglatin.utils.EnglishCharacterUtils.ABC_LOWER_CASED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CharUtilsTest {

    @Test
    public void testAbc() {
        assertEquals(ABC_LOWER_CASED.length(), 26);
        assertEquals(CharUtils.initCharacters(ABC_LOWER_CASED).size(), 26);
    }
}