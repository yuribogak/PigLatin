package com.bogak.citrix.translator.modifiers;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

import static com.bogak.citrix.translator.util.LetterUtil.*;

public abstract class AbstractModifier implements Modifier {

    @Override
    public String modify(String input) {
        List<Integer> capitals = capitalIndexes(input);
        List<Pair<Integer, Character>> punctuation = punctuationList(input);

        StringBuilder builder = preProcess(input);
        process(builder);
        postProcess(builder, capitals, punctuation);

        return builder.toString();
    }

    protected abstract void process(StringBuilder builder);

    protected abstract String getSuffix();

    private StringBuilder preProcess(String input) {
        return new StringBuilder(removePunctuation(input).toLowerCase());
    }

    private void postProcess(StringBuilder input, List<Integer> capitals, List<Pair<Integer, Character>> punctuation) {
        capitalizeString(input, capitals);
        restorePunctuation(input, punctuation, getShift());
    }

    private int getShift() {
        return getSuffix().length();
    }

}
