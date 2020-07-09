package com.bogak.citrix.translator.modifiers;

/**
 * Modifier to skip non translatable tokens.
 */
public class DoNothingModifier implements Modifier {

    @Override
    public String modify(String input) {
        return input;
    }
}
