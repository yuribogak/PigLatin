package com.bogak.citrix.translator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WordTranslatorTest {

    private WordTranslator wordTranslator;

    @Before
    public void setup() {
        wordTranslator = new WordTranslator();
    }

    @Test
    public void shouldTranslateVowelWord() {
        assertEquals("appleway", wordTranslator.translate("apple"));
    }


    @Test
    public void shouldNotTranslateWayEndingWords() {
        assertEquals("stairway", wordTranslator.translate("stairway"));
    }

    @Test
    public void shouldTranslateWithCapitalLetters() {
        assertEquals("Irdbay", wordTranslator.translate("Bird"));
        assertEquals("IrdBay", wordTranslator.translate("BirD"));
        assertEquals("IrDBay", wordTranslator.translate("BiRD"));
        assertEquals("CcLoudmay", wordTranslator.translate("McCloud"));
    }

    @Test
    public void shouldNotTranslateWithEmptyAndNull() {
        assertEquals("", wordTranslator.translate(""));
        assertNull(wordTranslator.translate(null));
    }
}
