package com.bogak.citrix.translator.util;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toUpperCase;

public class LetterUtil {

    public static final String VOWELS = "AEIOUaeiou";

    public static final String CONSONANTS = "bcdfghjklmnpqrstvxwyzBCDFGHJKLMNPQRSTVXWYZ";

    public static final String INWORD_PUNCTUATION_REGEX = "['&]";

    public static Pattern INWORD_PUNCTUATION_PATTERN = Pattern.compile(INWORD_PUNCTUATION_REGEX);

    private LetterUtil() {
    }

    public static boolean isVowel(String c) {
        return VOWELS.contains(c);
    }

    public static boolean isConsonant(CharSequence c) {
        return CONSONANTS.contains(c);
    }

    public static List<Integer> capitalIndexes(String input) {

        return IntStream
                .range(0, input.length())
                .filter(it -> isUpperCase(input.charAt(it)))
                .boxed()
                .collect(Collectors.toList());
    }

    public static void capitalizeString(StringBuilder input, List<Integer> indexes) {
        indexes.forEach(it -> input.setCharAt(it, toUpperCase(input.charAt(it))));
    }

    public static List<Pair<Integer, Character>> punctuationList(String input) {
        List<Pair<Integer, Character>> result = new ArrayList<>();

        Matcher matcher = INWORD_PUNCTUATION_PATTERN.matcher(input);

        while (matcher.find()) {
            int position = matcher.start();
            result.add(new ImmutablePair<>(position, input.charAt(position)));
        }

        return result;
    }

    public static void restorePunctuation(StringBuilder input, List<Pair<Integer, Character>> punctuation, int shift) {
        punctuation.forEach(it -> restorePunctuation(input, it.getKey(), it.getValue(), shift));
    }

    private static void restorePunctuation(StringBuilder input, int position, char character, int shift) {
        input.insert(position + shift, character);
    }

    public static String removePunctuation(String input) {
        return input.replaceAll(INWORD_PUNCTUATION_REGEX, "");
    }
}
