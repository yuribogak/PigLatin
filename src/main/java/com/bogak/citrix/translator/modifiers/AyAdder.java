package com.bogak.citrix.translator.modifiers;

/**
 * Words that start with a consonant have their first letter moved to the end of the word and the
 * letters “ay” added to the end.
 * <p>
 * bird -> irdbay
 * McCloud -> CcLoudmay
 */
public class AyAdder extends AbstractModifier {

    private static final String AY_SUFFIX = "ay";

    protected void process(StringBuilder input) {
        char firstChar = input.charAt(0);
        input.deleteCharAt(0).append(firstChar).append(getSuffix());
    }

    @Override
    protected String getSuffix() {
        return AY_SUFFIX;
    }
}
