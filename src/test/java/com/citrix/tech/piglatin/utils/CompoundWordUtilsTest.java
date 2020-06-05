package com.citrix.tech.piglatin.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompoundWordUtilsTest {

    @Test
    public void shouldReturnWordNotCompound() {
        assertFalse(CompoundWordUtils.isCompoundWord("hello"));
        assertFalse(CompoundWordUtils.isCompoundWord(""));
    }

    @Test
    public void shouldReturnWordCompound() {
        assertTrue(CompoundWordUtils.isCompoundWord("Humpty-Dumpty"));
        assertTrue(CompoundWordUtils.isCompoundWord("-"));
        assertTrue(CompoundWordUtils.isCompoundWord("one-two-three"));
    }

    @Test
    public void shouldSplitCompoundWords() {
        String compoundWord1 = "Humpty-Dumpty";
        final String compoundWordResult1 = CompoundWordUtils.splitMapAndJoinCompoundWord(
                compoundWord1, word -> word);
        assertEquals(compoundWord1, compoundWordResult1);

        String compoundWord2 = "humpty-dumpty";
        final String compoundWordResult2 = CompoundWordUtils.splitMapAndJoinCompoundWord(
                compoundWord2, String::toUpperCase);
        assertEquals("humpty-dumpty".toUpperCase(), compoundWordResult2);
    }
}