package com.yk.tech.piglatin.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EnglishCharacterUtilsTest {

    @Test
    public void shouldWordStartWithVowel() {
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("alabama"));
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("a"));
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("april"));

        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("april!"));
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("april1"));
    }

    @Test
    public void shouldNotWordStartWithVowel() {
        // On purpose, we work with lower cased words.
        assertFalse(EnglishCharacterUtils.wordStartsWithVowel("A"));

        assertFalse(EnglishCharacterUtils.wordStartsWithVowel("cat"));
        assertFalse(EnglishCharacterUtils.wordStartsWithVowel("1a"));
    }

    @Test
    public void shouldFailWithNullAndEmptyForVowelsCheck() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            //noinspection ConstantConditions
            EnglishCharacterUtils.wordStartsWithVowel(null);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            EnglishCharacterUtils.wordStartsWithVowel("");
        });
    }

    @Test
    public void shouldWordStartWithConsonant() {
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("cat"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("w"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("jeep"));

        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("j0"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("j."));
    }

    @Test
    public void shouldNotWordStartWithConsonant() {
        // On purpose, we work with lower cased words.
        assertFalse(EnglishCharacterUtils.wordStartsWithConsonant("Cat"));

        assertFalse(EnglishCharacterUtils.wordStartsWithConsonant("apple"));
        assertFalse(EnglishCharacterUtils.wordStartsWithVowel("1c"));
    }

    @Test
    public void shouldFailWithNullAndEmptyForConsonantCheck() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            //noinspection ConstantConditions
            EnglishCharacterUtils.wordStartsWithConsonant(null);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            EnglishCharacterUtils.wordStartsWithConsonant("");
        });
    }

    @Test
    public void shouldYBeConsonant() {
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("y"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("yellow"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("yo"));

        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("y2"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("y-"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("y."));

        // We do not work with upper-cased characters in CharUtils.
        // We will handle character case in WordTranslator.
        // This test should fail if the logic changes.
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("yA"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("yC"));
        assertTrue(EnglishCharacterUtils.wordStartsWithConsonant("yПривет"));
    }

    @Test
    public void shouldYBeVower() {
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("yc"));
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("ywis"));

        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("yc2"));
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("ywis-"));
        assertTrue(EnglishCharacterUtils.wordStartsWithVowel("yc2."));
    }

    @Test
    public void shouldReturnNoEnglishCharacter() {
        assertTrue(EnglishCharacterUtils.noEnglishCharacters(" "));
        assertTrue(EnglishCharacterUtils.noEnglishCharacters("\n"));
        assertTrue(EnglishCharacterUtils.noEnglishCharacters("\r"));
        assertTrue(EnglishCharacterUtils.noEnglishCharacters("\t"));
        assertTrue(EnglishCharacterUtils.noEnglishCharacters("+"));
        assertTrue(EnglishCharacterUtils.noEnglishCharacters("!"));
        assertTrue(EnglishCharacterUtils.noEnglishCharacters(",-"));
        assertTrue(EnglishCharacterUtils.noEnglishCharacters("...;!+@#0987654321привет."));
    }

    @Test
    public void shouldFindEnglishCharacter() {
        assertFalse(EnglishCharacterUtils.noEnglishCharacters(" \nA"));
        assertFalse(EnglishCharacterUtils.noEnglishCharacters("!+_@#a"));
        assertFalse(EnglishCharacterUtils.noEnglishCharacters(";Z"));
    }
}