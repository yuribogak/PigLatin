package com.bogak.citrix.translator;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public class PigLatin {

    private static final String WORDS_REGEX = "(?<=[\" .,?!-])|(?=[\" .,?!-])";

    private WordTranslator wordTranslator = new WordTranslator();

    public String translate(String input) {
        return ofNullable(input)
                .map(it -> it.split(WORDS_REGEX))
                .map(Arrays::stream)
                .map(this::translate)
                .orElse("");
    }

    private String translate(Stream<String> stringStream) {
        return stringStream
                .map(it -> wordTranslator.translate(it))
                .collect(Collectors.joining());
    }
}
