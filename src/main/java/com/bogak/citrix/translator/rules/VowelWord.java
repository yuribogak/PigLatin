package com.bogak.citrix.translator.rules;

import com.bogak.citrix.translator.modifiers.Modifier;
import com.bogak.citrix.translator.modifiers.WayAdder;
import com.bogak.citrix.translator.util.LetterUtil;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class VowelWord implements Rule {
    @Override
    public boolean isApplicable(String word) {
        return isNotBlank(word) && LetterUtil.isVowel(word.substring(0, 1));
    }

    @Override
    public Modifier apply() {
        return new WayAdder();
    }
}
