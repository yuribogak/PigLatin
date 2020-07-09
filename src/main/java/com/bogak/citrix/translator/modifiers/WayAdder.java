package com.bogak.citrix.translator.modifiers;

/**
 * Words that start with a vowel have the letters “way” added to the end.
 * <p>
 * apple -> appleway
 * ain't -> aintwa'y
 * i'll -> illw'ay
 */
public class WayAdder extends AbstractModifier {

    private static final String WAY_SUFFIX = "way";

    @Override
    protected void process(StringBuilder builder) {
        builder.append(getSuffix());
    }

    @Override
    protected String getSuffix() {
        return WAY_SUFFIX;
    }

}
