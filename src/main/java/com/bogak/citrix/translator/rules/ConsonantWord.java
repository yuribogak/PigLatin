package com.bogak.citrix.translator.rules;

import com.bogak.citrix.translator.modifiers.AyAdder;
import com.bogak.citrix.translator.modifiers.Modifier;
import com.bogak.citrix.translator.util.LetterUtil;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class ConsonantWord implements Rule {

    @Override
    public boolean isApplicable(String word) {
        return isNotBlank(word) && LetterUtil.isConsonant(word.substring(0, 1));

    }

    @Override
    public Modifier apply() {
        return new AyAdder();
    }
}
