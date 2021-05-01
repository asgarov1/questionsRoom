package com.asgarov.qanda.util;

import java.util.Random;

public class WordGenerator {
    private static final int NUMERAL_ZERO = 48;
    private static final int CAPITAL_A = 65;
    private static final int LOWER_CASE_Z = 122;

    public static String generateAlphanumeric(int targetLength) {
        return new Random().ints(NUMERAL_ZERO, LOWER_CASE_Z + 1)
                .filter(Character::isLetterOrDigit)
                .limit(targetLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generateAlphabetic(int targetLength) {
        return new Random().ints(CAPITAL_A, LOWER_CASE_Z + 1)
                .filter(Character::isLetter)
                .limit(targetLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
