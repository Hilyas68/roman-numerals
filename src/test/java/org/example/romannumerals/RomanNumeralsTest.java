package org.example.romannumerals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    static RomanNumerals romanNumerals;

    @BeforeAll
    public static void beforeAll() {
        romanNumerals = new RomanNumerals();
    }

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "5, V",
            "10, X",
            "50, L",
            "100, C",
            "500, D",
            "1000, M",
            "4, IV",
            "9, IX",
            "40, XL",
            "90, XC",
            "400, CD",
            "900, CM"
    })
    public void givenNumberValueThenConvertToExpectedNumeral(int number, String romanNumeral) {
        assertEquals(romanNumeral, romanNumerals.convertToNumeral(number));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, IllegalArgumentException",
            "4000, IllegalArgumentException"
    })
    public void givenInvalidNumberValueThenThrowException(int number, Class<? extends Exception> exceptionClass) {
        assertThrows(exceptionClass, () -> romanNumerals.convertToNumeral(number));
    }
}
