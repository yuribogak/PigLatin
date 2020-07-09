package com.bogak.citrix.translator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTest {
    private PigLatin pigLatin;

    @Before
    public void setup() {
        pigLatin = new PigLatin();
    }

    @Test
    public void shouldTranslateToPigLatin() {
        assertEquals("Ellohay erehay", pigLatin.translate("Hello here"));
        assertEquals("Ellohay erehay stairway", pigLatin.translate("Hello here stairway"));
        assertEquals("Ellohay CcLoudmay erehay stairway", pigLatin.translate("Hello McCloud here stairway"));
    }

    @Test
    public void shouldTranslateToPigLatinWithPunctuations() {
        assertEquals("Ellohay erehay!", pigLatin.translate("Hello here!"));
        assertEquals("Ellohay? Isway erehay away stairway?!", pigLatin.translate("Hello? Is here a stairway?!"));
        assertEquals("Ellohay erehay stairway.", pigLatin.translate("Hello here stairway."));
        assertEquals("Ellohay stairway erehay.", pigLatin.translate("Hello stairway here."));
        assertEquals("Ellohay rsmay. ohAr'away!", pigLatin.translate("Hello mrs. o'Hara!"));
        assertEquals("Ellohay \"histay\" isway uotationqay esttay!", pigLatin.translate("Hello \"this\" is quotation test!"));
    }

    @Test
    public void shouldTranslateToPigLatinWithHyphens() {
        assertEquals("Ellohay histay-hingtay antca'y ebay kippedsay.", pigLatin.translate("Hello this-thing can't be skipped."));
    }

    @Test
    public void shouldNotTranslateToPigLatin() {
        assertEquals("1Hello 2This 3Is 4Not 5Translatable", pigLatin.translate("1Hello 2This 3Is 4Not 5Translatable"));
        assertEquals("", pigLatin.translate(""));
        assertEquals("", pigLatin.translate(null));
    }
}
