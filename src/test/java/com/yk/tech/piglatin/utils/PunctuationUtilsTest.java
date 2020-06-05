package com.yk.tech.piglatin.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PunctuationUtilsTest {

    @Test
    public void shouldRemovePunctuation() {
        String word = "john,hi;hello!can't?wait+-(no-way)[and]_{this}\"'...";
        String noPunctuation = PunctuationUtils.removePunctuation(word);
        assertEquals("johnhihellocantwait+-no-wayand_this", noPunctuation);

        assertTrue(noPunctuation.contains(CompoundWordUtils.HYPHEN)); // Hyphen should not be removed here.
    }

    @Test
    public void shouldNotRemovePunctuationFromEmpty() {
        assertEquals(PunctuationUtils.removePunctuation(""), "");
    }

    @Test
    public void shouldFailToRemovePunctuationFromNull() {
        assertThrows(NullPointerException.class, () -> {
            //noinspection ConstantConditions
            PunctuationUtils.removePunctuation(null);
        });
    }

    @Test
    public void shouldApplyPunctuation() {
        StringBuilder noPunctuation1 = new StringBuilder("cant");
        PunctuationUtils.applyPunctuation("can't", noPunctuation1);
        assertEquals("can't", noPunctuation1.toString());

        StringBuilder noPunctuation2 = new StringBuilder("Finish");
        PunctuationUtils.applyPunctuation("Finish.", noPunctuation2);
        assertEquals("Finish.", noPunctuation2.toString());

        StringBuilder noPunctuation3 = new StringBuilder("Ill_come_backMore_stuff");
        PunctuationUtils.applyPunctuation(".More_stuff.", noPunctuation3);
        assertEquals("Ill_come_back.More_stuff.", noPunctuation3.toString());
    }
}