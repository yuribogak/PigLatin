package com.bogak.citrix.translator;

import com.bogak.citrix.translator.rules.*;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Single word translator.
 * Rules order is important.
 */
class WordTranslator {

    private final List<Rule> rules;

    public WordTranslator() {
        this.rules = asList(new WayEnding(),
                new ConsonantWord(),
                new VowelWord(),
                new DoNothing());
    }

    public String translate(String input) {

        return rules.stream()
                .filter(it -> it.isApplicable(input))
                .findFirst()
                .map(Rule::apply)
                .orElseThrow(IllegalStateException::new)
                .modify(input);
    }
}
