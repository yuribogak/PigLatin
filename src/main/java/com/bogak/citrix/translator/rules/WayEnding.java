package com.bogak.citrix.translator.rules;

import com.bogak.citrix.translator.modifiers.DoNothingModifier;
import com.bogak.citrix.translator.modifiers.Modifier;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class WayEnding implements Rule {

    private static final String WAY_SUFFIX = "way";

    @Override
    public boolean isApplicable(String word) {
        return isNotBlank(word) && word.endsWith(WAY_SUFFIX);
    }

    @Override
    public Modifier apply() {
        return new DoNothingModifier();
    }
}
