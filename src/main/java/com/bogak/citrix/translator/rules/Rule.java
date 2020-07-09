package com.bogak.citrix.translator.rules;

import com.bogak.citrix.translator.modifiers.Modifier;

public interface Rule {

    boolean isApplicable(String word);

    Modifier apply();
}
