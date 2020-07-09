package com.bogak.citrix.translator.rules;

import com.bogak.citrix.translator.modifiers.DoNothingModifier;
import com.bogak.citrix.translator.modifiers.Modifier;

/**
 * Dummy rule for not translatable words, punctuations and so on.
 */
public class DoNothing implements Rule {
    @Override
    public boolean isApplicable(String word) {
        return true;
    }

    @Override
    public Modifier apply() {
        return new DoNothingModifier();
    }
}
